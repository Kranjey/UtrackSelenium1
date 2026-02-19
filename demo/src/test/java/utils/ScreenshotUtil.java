package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    
    public static void takeScreenshotOnFailure(ITestResult result, WebDriver driver) {
        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            String screenshotName = result.getName() + "_" + 
                new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = "screenshots/" + screenshotName + ".png";
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (IOException e) {
                System.err.println("Failed to take screenshot: " + e.getMessage());
            }
        }
    }
}