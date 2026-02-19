package com.example.pages;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class IssuePage extends BasePage {

    @FindBy(xpath = "//*[contains(@data-test, 'ring-link issues-button')]")
    private WebElement selectIssuePage;
    
    @FindBy(xpath = "//*[contains(@data-test, 'createIssueButton')]")
    private WebElement issueButton;
    @FindBy(xpath = "//textarea[contains(@data-test, 'summary') and contains(@placeholder, 'Заголовок')]")
    private WebElement summaryField;

    @FindBy(xpath = "//*[contains(@data-test, 'wysiwyg-editor-content')]")
    private WebElement descriptionField;
    
    @FindBy(xpath = "//*[contains(@data-test, 'submit-button')]")
    private WebElement submitButton;
    
    @FindBy(xpath = "//*[contains(@data-test, 'alert') and contains(@data-test-type, 'success')]")
    private WebElement successMessage;

    public IssuePage(WebDriver driver) {
        super(driver);
    }

    public void switchtoIssue(){
        selectIssuePage.click();
    }

    public void clickIssue(){
        wait.until(ExpectedConditions.visibilityOf(issueButton));
        issueButton.click();
    }
    
    public void enterSummary(String summary) {
        wait.until(ExpectedConditions.visibilityOf(summaryField));
        summaryField.click();
        summaryField.sendKeys(summary);
    }
    
    public void enterDescription(String description) {
        descriptionField.click();
        descriptionField.sendKeys(description);
    }
    
    
    public void clickSubmit() {
        submitButton.click();
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
            return successMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isButtonEnabled() {
        try {
            return submitButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}