package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.config.TestConfig;
import com.example.pages.ProjectPage;
import com.example.utils.DriverFactory;

public class CreateProjectTest extends BaseTest
{
     @Test(description = "Позитивный тест: Создание нового проекта")
    public void testCreateProjectSuccessfully() {
        projectPage = new ProjectPage(DriverFactory.getDriver());
        loginPage.login(TestConfig.getValidUsername(), TestConfig.getValidPassword());
        String projectName = "Новый проект" + System.currentTimeMillis();
        String projectId = "ID" + System.currentTimeMillis();
        projectPage.createProject(projectName,projectId);
        Assert.assertTrue(projectPage.isProjectCreatedSuccessfully(), 
            "Project is not created");
    }
}
