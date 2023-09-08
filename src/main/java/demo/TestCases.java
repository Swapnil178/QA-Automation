package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.openqa.selenium.support.ui.Select;
///
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
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

    
    public  void SearchAmazon() throws InterruptedException
    {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        //Navigate to google Home Page https://www.google.com/
        driver.get("https://www.google.com");
        //Enter text in google search text box Using Locator "ID" q | sendKeys("amazon")
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("Amazon");
        //Click on google search button Using Locator "XPath" //input[@value='Google Search']
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        //Validate amazon.in is displayed Using Locator "XPath" //span[text()='Amazon.in']
        WebElement result = driver.findElement(By.xpath("//span[text()='Amazon.in'"));
        System.out.println("Is Amazon present in results?:" + result);
        //Validate amazon.com is displayed Using Locator "XPath" //span[test()='Amazon.com']
        //Close the browser Using locator "ID" driver.close();
        //driver.close();
        System.out.println("end Test case: testCase01");
}

}



