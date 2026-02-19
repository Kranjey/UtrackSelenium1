package com.example.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "config.properties";
    
    static {
        try (InputStream input = TestConfig.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                loadFromFileSystem();
            } else {
                properties.load(input);
            }
        } catch (IOException e) {
            System.err.println("Ошибка загрузки конфигурации: " + e.getMessage());
        }
    }
    
    private static void loadFromFileSystem() throws IOException {
        try (InputStream input = new FileInputStream("src/test/resources/" + CONFIG_FILE)) {
            properties.load(input);
        }
    }
    
    
    public static String getBaseUrl() {
        return System.getProperty("baseUrl", properties.getProperty("baseUrl", "http://localhost:8080"));
    }
    
    public static String getUsername() {
        return System.getProperty("username", properties.getProperty("username", "admin"));
    }
    
    public static String getPassword() {
        return System.getProperty("password", properties.getProperty("password", "admin12"));
    }
    
    public static String getValidUsername() {
        return System.getProperty("validUsername", properties.getProperty("validUsername", "admin"));
    }
    
    public static String getValidPassword() {
        return System.getProperty("validPassword", properties.getProperty("validPassword", "admin12"));
    }
    
    public static String getInvalidUsername() {
        return System.getProperty("invalidUsername", properties.getProperty("invalidUsername", "invalid_user"));
    }
    
    public static String getInvalidPassword() {
        return System.getProperty("invalidPassword", properties.getProperty("invalidPassword", "wrong_password"));
    }
    
    public static String getTestProject() {
        return System.getProperty("testProject", properties.getProperty("testProject", "TEST"));
    }
    
    public static String getBrowser() {
        return System.getProperty("browser", properties.getProperty("browser", "chrome"));
    }
    
    public static boolean isHeadless() {
        return Boolean.parseBoolean(System.getProperty("headless", properties.getProperty("headless", "true")));
    }
    
    public static String getProperty(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }
}