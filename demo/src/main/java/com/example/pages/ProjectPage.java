package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage{

    private By selectProjectPage = By.xpath("//*[contains(@data-test, 'ring-link projects-button')]");
    private By createProjectButton = By.xpath("//a[contains(@href, 'projects/create')]");
    private By patternButton = By.xpath("//button[contains(@data-test, 'template')]");
    private By patternAcceptButton = By.xpath("//button[contains(@data-test, 'accept-button')]");
    private By projectNameField = By.xpath("//*[contains(@data-test, 'project-name')]");
    private By projectIdField = By.xpath("//*[contains(@data-test, 'project-id')]");
    private By acceptButton = By.xpath("//button[contains(@type, 'submit')]");
    private By nextButton = By.xpath("//button[contains(@data-test, 'skip')]");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    
    public void switchtoProject(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(selectProjectPage)));
        driver.findElement(selectProjectPage).click();
    }

    public void clickProject(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(createProjectButton)));
        driver.findElement(createProjectButton).click();
    }

    public void clickPattern(){
        driver.findElement(patternButton).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(patternAcceptButton)));
        driver.findElement(patternAcceptButton).click();
    }
    
    public void enterName(String projectName) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(projectNameField)));
        driver.findElement(projectNameField).click();
        driver.findElement(projectNameField).sendKeys(projectName);
    }
    
    public void enterID(String projectID) {
        driver.findElement(projectIdField).click();
        driver.findElement(projectIdField).sendKeys(projectID);
    }
    
    
    public void clickSubmit() {
        driver.findElement(acceptButton).click();
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
            return driver.findElement(nextButton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
