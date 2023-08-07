package testcases;

import basics.Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FrameTC extends Base {
    By framePage= By.partialLinkText("WYSIWYG Editor");
    By TextID=By.id("tinymce");
    String frameID="mce_0_ifr";
    //not complated
    @Test
    public void TC01(){
        driver.findElement(framePage).click();
        driver.switchTo().frame(frameID);
        driver.findElement(TextID).clear();
        driver.switchTo().parentFrame();
    }

}
