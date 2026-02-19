package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginNegativeTest extends BaseTest { 
      @Test(description = "Негативный тест: Аутентификация с неверными данными", 
          dataProvider = "invalidLoginData", 
          dataProviderClass = data.AuthTestData.class)
    public void testFailedLogin(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), 
            "Сообщение об ошибке не отображается");
        Assert.assertFalse(loginPage.isLoggedIn(), 
            "Logged with invalid");
    }
}
