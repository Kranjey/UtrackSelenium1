package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.config.TestConfig;

public class CreateProjectTest extends BaseTest
{
     @Test(description = "Позитивный тест: Создание нового проекта")
    public void testCreateProjectSuccessfully() {
        loginPage.login(TestConfig.getValidUsername(), TestConfig.getValidPassword());
        String projectName = "Новый проект" + System.currentTimeMillis();
        String projectId = "ID" + System.currentTimeMillis();
        projectPage.createProject(projectName,projectId);
        Assert.assertTrue(projectPage.isProjectCreatedSuccessfully(), 
            "Задача не была создана успешно");
        System.out.println("Project created " + projectName);
    }
}
