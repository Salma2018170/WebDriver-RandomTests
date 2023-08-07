package basics;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Base {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://the-internet.herokuapp.com/");
    }

    @Test
    public void tryy() {
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @AfterMethod
    public void recordeFailure(ITestResult result) {
        //condition to print in case test fail will take screenShot
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            //We can save the screenshot as a file using the “java.io” package
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot.toPath(), new File("resources/screenshots/testTRY.png").toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // System.out.println(screenshot.getAbsolutePath());
        }


    }
}
