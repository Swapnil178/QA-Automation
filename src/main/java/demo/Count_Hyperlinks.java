package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Count_Hyperlinks {
    WebDriver driver;

    public Count_Hyperlinks()
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

     public void CountHyperlinks() throws InterruptedException 
     {

        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        Thread.sleep(1000);

        List<WebElement> link = driver.findElements(By.tagName("a"));
        Thread.sleep(1000);
        // List<WebElement> link = driver.findElements(By.xpath("//a"));

        System.out.println(link.size());
    }
}
