package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nested_Frames {
    ChromeDriver driver;

    public Nested_Frames()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void NestedFrames()
    {
        //Navigate to the url https://the-internet.herokuapp.com/nested_frames
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //Switch to parent top frame switchTo().frame("frame-top)
        driver.switchTo().frame("frame-top");
        //Switch to child left frame switchTo().frame("frame-top)
        driver.switchTo().frame("frame-left");
        //Print the text present in the left frame "/html/body")).getText()
        System.out.println(driver.findElement(By.xpath("/html/body")).getText());
        //Switch back to parent frame switchTo().frame("frame-top)
        driver.switchTo().parentFrame();
        //Switch to child middle frame switchTo().frame("frame-middle)
        driver.switchTo().frame("frame-middle");
        //Print the text present in the middle frame id("content")).getText()
        System.out.println(driver.findElement(By.id("content")).getText());
        //Switch back to parent frame switchTo().frame("frame-top)
        driver.switchTo().parentFrame();
        //Switch to child Right frame switchTo().frame("frame-right)
        driver.switchTo().frame("frame-right");
        //Print the text present in the Right frame "/html/body")).getText()
        System.out.println(driver.findElement(By.xpath("/html/body")).getText());
        //Switch back to Default frame switchTo().defaultContent()
        driver.switchTo().defaultContent();
        //Switch to bottom frame switchTo().frame("frame-bottom)
        driver.switchTo().frame("frame-bottom");
        //Print the text present in Bottom frame "/html/body")).getText()
        System.out.println(driver.findElement(By.xpath("/html/body")).getText());


    }
}
