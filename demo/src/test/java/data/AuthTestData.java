package data;

import com.example.config.TestConfig;
import org.testng.annotations.DataProvider;

public class AuthTestData { 
    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][] {
            {TestConfig.getInvalidUsername(), TestConfig.getInvalidPassword()},
            {TestConfig.getValidUsername(), TestConfig.getInvalidPassword()},
            {"", TestConfig.getValidPassword()},
            {TestConfig.getValidUsername(), ""}
        };
    }
}