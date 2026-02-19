package tests;

import com.example.config.TestConfig;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.example.pages.IssuePage;
import com.example.pages.LoginPage;
import com.example.utils.DriverFactory;
import utils.ScreenshotUtil;

public class CreateIssuePositiveTest extends BaseTest{
    @Test(description = "Позитивный тест: Создание новой задачи")
    public void testCreateIssueSuccessfully() {
        issuePage = new IssuePage(DriverFactory.getDriver());
        loginPage.login(TestConfig.getValidUsername(), TestConfig.getValidPassword());
        String summary = "Тестовая задача " + System.currentTimeMillis();
        String description = "Описание тестовой задачи для автоматизированного теста";
        issuePage.createIssue(summary, description);
        Assert.assertTrue(issuePage.isIssueCreatedSuccessfully(), 
            "Issue is not created");
    }
}