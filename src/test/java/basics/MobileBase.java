package basics;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import listeners.ListenersDemo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
@Listeners(ListenersDemo.class)
public class MobileBase {

   AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
     UiAutomator2Options options=new UiAutomator2Options()
             .setApp("C:\\Users\\salma_abdeltawab\\Downloads\\SeleniumWebDrivers-Practice\\src\\app\\mobile-mobileAppDevelopmentDebug-1.75-2023-05-29.apk")
             .setAutomationName("UiAutomator2");
     AndroidDriver driver = new AndroidDriver(
             // The default URL in Appium 1 is http://127.0.0.1:4723/wd/hub
             new URL("http://127.0.0.1:4723"), options
     );
    }
    @Test
    public void tryy(){

    }
    @AfterClass
    public void tearDown(){
     driver.quit();
    }
}
