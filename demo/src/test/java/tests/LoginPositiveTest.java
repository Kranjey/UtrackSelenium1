package tests;

import com.example.config.TestConfig;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPositiveTest extends BaseTest { 

      @Test(description = "Позитивный тест: Успешная аутентификация")
    public void testSuccessfulLogin() {
        String username = TestConfig.getValidUsername();
        String password = TestConfig.getValidPassword();
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isLoggedIn(), "Unauthorized with Valid Data");
    }
}