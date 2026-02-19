package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.example.config.TestConfig;
import com.example.pages.IssuePO;
import com.example.pages.LoginPO;
import com.example.utils.DriverFactory;

import utils.ScreenshotUtil;

public class CreateIssueNegativeTest extends BaseTest{
    @Test(description = "Негативный тест: Создание задачи без обязательных полей")
    public void testCreateIssueWithoutRequiredFields() {
        loginPage.login(TestConfig.getValidUsername(), TestConfig.getValidPassword());
        issuePage.enterIssuePage();
        issuePage.clickSubmit();     
        Assert.assertFalse(issuePage.isButtonEnabled(), 
            "Ошибка валидации не отображается");
        System.out.println("Issue not created");
    }
}
