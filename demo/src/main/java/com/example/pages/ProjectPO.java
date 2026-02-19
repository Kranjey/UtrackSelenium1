package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPO extends BasePO{
    @FindBy(xpath = "//*[contains(@data-test, 'ring-link projects-button')]")
    private WebElement selectProjectPage;

    @FindBy(xpath = "//a[contains(@href, 'projects/create')]")
    private WebElement createProjectButton;
    
    @FindBy(xpath = "//button[contains(@data-test, 'template')]")
    private WebElement patternButton;

    @FindBy(xpath = "//button[contains(@data-test, 'accept-button')]")
    private WebElement patternAcceptButton;
    
    @FindBy(xpath = "//*[contains(@data-test, 'project-name')]")
    private WebElement projectNameField;
    
    @FindBy(xpath = "//*[contains(@data-test, 'project-id')]")
    private WebElement projectIdField;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement acceptButton;

    @FindBy(xpath = "//button[contains(@data-test, 'skip')]")
    private WebElement nextButton;

    public ProjectPO(WebDriver driver) {
        super(driver);
    }
    
    public void switchtoProject(){
        selectProjectPage.click();
    }

    public void clickProject(){
        createProjectButton.click();
    }

    public void clickPattern(){
        patternButton.click();
        wait.until(ExpectedConditions.visibilityOf(patternAcceptButton));
        patternAcceptButton.click();
    }
    
    public void enterName(String projectName) {
        wait.until(ExpectedConditions.visibilityOf(projectNameField));
        projectNameField.click();
        projectNameField.sendKeys(projectName);
    }
    
    public void enterID(String projectID) {
        projectIdField.click();
        projectIdField.sendKeys(projectID);
    }
    
    
    public void clickSubmit() {
        acceptButton.click();
    }
    
    public void enterProjectPage(){
        switchtoProject();
        clickProject();
    }
    public void createProject(String projectName, String projectId) {
        enterProjectPage();
        clickPattern();
        enterName(projectName);
        enterID(projectId);
        clickSubmit();
    }
    
    public boolean isProjectCreatedSuccessfully() {
        try {
            return nextButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
