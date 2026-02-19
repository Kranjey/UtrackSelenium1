package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    
    private By usernameField = By.xpath("//*[@id=\"username\"]");
    private By passwordField = By.xpath("//*[@id=\"password\"]");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//*[contains(@data-test, 'error-message')]");
    private By ytIcon = By.xpath("//*[contains(@data-test, 'ring-link application-logo')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void enterUsername(String username) {
        //wait.until(ExpectedConditions.visibilityOf(usernameField));
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }
    
    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public boolean isErrorMessageDisplayed() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
    
    public boolean isLoggedIn() {
        try {
            return driver.findElement(ytIcon).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}