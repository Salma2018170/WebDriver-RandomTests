package testcases;

import basics.Base;
import listeners.ListenersDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenersDemo.class)
public class FileUploadTc extends Base {
    By fileUploadPage=By.partialLinkText("File Upload");
    By chooseFileButton=By.id("file-upload");
    By fileUploadButton=By.id("file-submit");
    //pop
    @Test
    public void TC01(){
        driver.findElement(fileUploadPage).click();
        driver.findElement(chooseFileButton).sendKeys("C:\\Users\\salma_abdeltawab\\Downloads\\c1.png");

        WebElement element=driver.findElement(fileUploadButton);
        element.click();
        String message=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(message ,"File Uploaded!GGGG","file not uploaded");

    }
}
