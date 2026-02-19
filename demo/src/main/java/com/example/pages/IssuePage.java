package com.example.pages;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class IssuePage extends BasePage {

    private By selectIssuePage = By.xpath("//*[contains(@data-test, 'ring-link issues-button')]");  
    private By issueButton = By.xpath("//*[contains(@data-test, 'createIssueButton')]");
    private By summaryField = By.xpath("//textarea[contains(@data-test, 'summary') and contains(@placeholder, 'Заголовок')]");
    private By descriptionField = By.xpath("//*[contains(@data-test, 'wysiwyg-editor-content')]");
    private By submitButton = By.xpath("//*[contains(@data-test, 'submit-button')]");
    private By successMessage = By.xpath("//*[contains(@data-test, 'alert') and contains(@data-test-type, 'success')]");

    public IssuePage(WebDriver driver) {
        super(driver);
    }

    public void switchtoIssue(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectIssuePage)));
        driver.findElement(selectIssuePage).click();
    }

    public void clickIssue(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(issueButton)));
        driver.findElement(issueButton).click();
    }
    
    public void enterSummary(String summary) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(summaryField)));
        driver.findElement(summaryField).click();
        driver.findElement(summaryField).sendKeys(summary);
    }
    
    public void enterDescription(String description) {
        driver.findElement(descriptionField).click();
        driver.findElement(descriptionField).sendKeys(description);
    }
    
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }
    
    public void enterIssuePage(){
        switchtoIssue();
        clickIssue();
    }
    public void createIssue(String summary, String description) {
        enterIssuePage();
        enterSummary(summary);
        enterDescription(description);
        clickSubmit();
    }
    
    public boolean isIssueCreatedSuccessfully() {
        try {
            return driver.findElement(successMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isButtonEnabled() {
        try {
            return driver.findElement(submitButton).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}