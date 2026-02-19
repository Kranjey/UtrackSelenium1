package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.example.config.TestConfig;
import com.example.pages.IssuePage;
import com.example.pages.LoginPage;
import com.example.pages.ProjectPage;
import com.example.utils.DriverFactory;

import utils.ScreenshotUtil;

public class BaseTest {
    
    protected LoginPage loginPage; 
    protected IssuePage issuePage;
    protected ProjectPage projectPage;
    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(DriverFactory.getDriver());
        loginPage.openUrl(TestConfig.getBaseUrl());
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        ScreenshotUtil.takeScreenshotOnFailure(result, DriverFactory.getDriver());
        DriverFactory.quitDriver();
    }
}
