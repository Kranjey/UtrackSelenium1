package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.example.config.TestConfig;
import com.example.pages.IssuePO;
import com.example.pages.LoginPO;
import com.example.pages.ProjectPO;
import com.example.utils.DriverFactory;

import utils.ScreenshotUtil;

public class BaseTest {
    
    protected LoginPO loginPage; 
    protected IssuePO issuePage;
    protected ProjectPO projectPage;
    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPO(DriverFactory.getDriver());
        loginPage.openUrl(TestConfig.getBaseUrl());
        issuePage = new IssuePO(DriverFactory.getDriver());
        projectPage = new ProjectPO(DriverFactory.getDriver());
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        ScreenshotUtil.takeScreenshotOnFailure(result, DriverFactory.getDriver());
        DriverFactory.quitDriver();
    }
}
