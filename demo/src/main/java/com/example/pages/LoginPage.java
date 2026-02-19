package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement usernameField;
    
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//*[contains(@data-test, 'error-message')]")
    private WebElement errorMessage;
    
    @FindBy(xpath = "//*[contains(@data-test, 'ring-link application-logo')]")
    private WebElement ytIcon;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public void clickLogin() {
        loginButton.click();
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getErrorMessageText() {
        return errorMessage.getText();
    }
    
    public boolean isLoggedIn() {
        try {
            return ytIcon.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}