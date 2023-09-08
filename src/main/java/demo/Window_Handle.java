package demo;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handle {
    WebDriver driver;

    public Window_Handle()
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
    public static void TakesScreenshot(WebDriver driver2)
    {
        String homepath = System.getProperty("user.dir") + "src\\main\\java\\demo\\Screenshots\\SS.png";
         try 
         {
            TakesScreenshot scrShot = ((TakesScreenshot) driver2);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(homepath);
            FileUtils.copyFile(SrcFile, DestFile);
        } 
        catch (Exception e) 
        {
            System.out.println("Error while saving screenshot: " + e.getMessage());
        }
    }

    public void WindowHandle()
    {
        // "Navigate to the URL https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open"
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
        // Switch to iframe Using Locator "ID" WebElement frameele = driver.findElement(By.id("iframeResult"));
        WebElement frameele = driver.findElement(By.id("iframeResult"));
 
        driver.switchTo().frame(frameele);
        // Click on the 'Try it' button Using Locator "XPath" //button[contains(text(),'Try it')]
        String url = "";
        String Tittle = "";
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        // Switch to new window driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handles.toArray(new String[handles.size()])[1]);
        // Get the URL and Title Using Locator "XPath" url = driver.getCurrentUrl(); Tittle = driver.getTitle(); System.out.println(url); System.out.println(Tittle)
        url = driver.getCurrentUrl();
        Tittle = driver.getTitle();
        System.out.println(url);
        System.out.println(Tittle);
        // Take the Screenshot TakesScreenshot(driver)
        TakesScreenshot(driver);
        // Close the window driver.close()
         driver.close();
        // Switch back to the original window by using the window handle driver.switchTo().window(handles.toArray(new String[handles.size()])[0]
        driver.switchTo().window(handles.toArray(new String[handles.size()])[0]);
    }
}
