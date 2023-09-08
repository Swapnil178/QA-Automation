package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Post_LinkedIn {
    ChromeDriver driver;

    public Post_LinkedIn()
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

    public void PostLinkedIn()
    {
        System.out.println("Start Test case: testCase01");
        // Navigate to URL" https://in.linkedin.com/ "
        driver.get("https://in.linkedin.com/");
        // Enter the Email ID in MAil ID text field Using Locator "ID" session_key
        // Enter the Password in Password text field Using Locator "ID" session_password
        driver.findElement(By.name("Username")).sendKeys("Swapnil");
        driver.findElement(By.name("Password")).sendKeys("Password@123");
        // Click on the Sign In button Using Locator "XPath" //button[contains(text(),'Sign in')]
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        // Print the count of who's viewed your profile Using Locator "XPath" (//div/span/strong)[1]
         List<WebElement> views = driver.findElements(By.xpath("(//div/span/strong)[1]"));
         System.out.println(views.size());
        // Click on Profile button to select the "Connection only" Using Locator "XPath" //button[@class='share-unified-settings-entry-button']
        driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']"));
        // Select "Connection Only" option Using Locator "XPath" //span[@class='sharing-shared-generic-list__description-double-line']
        driver.findElement(By.xpath("//span[@class='sharing-shared-generic-list__description-double-line']")).click();
        // Click on the Image Icon Using Locator "XPath" (//li/div/div/span/button[@type='button']/span)[1]
        driver.findElement(By.xpath("(//li/div/div/span/button[@type='button']/span)[1]")).click();
        // After upload click on Post Using Locator "XPath" //div/div/button[@id='ember1308']/span[@class='artdeco-button__text']
        driver.findElement(By.xpath("//div/div/button[@id='ember1308']/span[@class='artdeco-button__text']"));

    }
    
}
