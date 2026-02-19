package tests;

import com.example.config.TestConfig;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.example.pages.IssuePO;
import com.example.pages.LoginPO;
import com.example.utils.DriverFactory;
import utils.ScreenshotUtil;

public class CreateIssuePositiveTest extends BaseTest{
    @Test(description = "Позитивный тест: Создание новой задачи")
    public void testCreateIssueSuccessfully() {
        loginPage.login(TestConfig.getValidUsername(), TestConfig.getValidPassword());
        String summary = "Тестовая задача " + System.currentTimeMillis();
        String description = "Описание тестовой задачи для автоматизированного теста";
        String project = TestConfig.getTestProject();
        issuePage.createIssue(summary, description, project);
        Assert.assertTrue(issuePage.isIssueCreatedSuccessfully(), 
            "Задача не была создана успешно");
        System.out.println("Issue created " + summary);
    }
}