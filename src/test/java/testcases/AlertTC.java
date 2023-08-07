package testcases;

import basics.Base;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTC extends Base {
//Element
    private By alertPage=By.partialLinkText("JavaScript Alerts");
    private By jsAlertButton=By.xpath("//button[text()='Click for JS Alert']");
    private By jsAlertButton2=By.xpath("//button[text()='Click for JS Confirm']");
    private By jsAlertButton3=By.xpath("//button[text()='Click for JS Prompt']");
    private By firstMessage=By.id("result");
    @Test(description = "accept alert")
    public void TC01(){
     driver.findElement(alertPage).click();
     driver.findElement(jsAlertButton).click();
     //click on okay in alert message
        driver.switchTo().alert().accept();
        String message=driver.findElement(firstMessage).getText();
        Assert.assertEquals(message,"You successfully clicked an alert","message incorrect");
    }
    @Test(description = "dismiss alert")
    public void TC02(){
        driver.findElement(alertPage).click();
        driver.findElement(jsAlertButton2).click();
        //get alert message ans assert on it
      String messageAlert=  driver.switchTo().alert().getText();
       Assert.assertEquals(messageAlert,"I am a JS Confirm","alert message incorrect");
        //click on cancel in alert message
        driver.switchTo().alert().dismiss();




        String messageResult=driver.findElement(firstMessage).getText();
        Assert.assertEquals(messageResult,"You clicked: Cancel","message incorrect");
    }
    @Test(description = "send text in alert")
    public void TC03(){
        driver.findElement(alertPage).click();
        driver.findElement(jsAlertButton3).click();
        //click on cancel in alert message
        driver.switchTo().alert().sendKeys("hi there");
        driver.switchTo().alert().accept();
        String messageResult=driver.findElement(firstMessage).getText();
        Assert.assertEquals(messageResult,"You entered: hi there","message incorrect");
    }
}
