package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image_Url {
     WebDriver driver;

    public Image_Url() {

        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void ImageUrl() throws InterruptedException 
    {
        //"Open URLhttps://in.bookmyshow.com/explore/home/chennai
        driver.get("https://www.bookmyshow.com/explore/home/chennai");
        //"Get the WebElement tab of Recommended movies in list.Using getAttribute method Using Locator ""XPath"" //h2[contains(text(),'Recommended Movies')]/../../../..//img"
        //"Iterate through all the WebElements and print all the URL'seach"
        List<WebElement> list = driver
                .findElements(By.xpath("//h2[contains(text(),'Recommended Movies')]/../../../..//img"));

        for (WebElement count : list) {
            System.out.println(count.getAttribute("src"));
        }
        Thread.sleep(1000);
        //"Find the premier list of movies and get teh second movie using getAtribute method Using Locator ""XPath"" //h2[contains(text(),'Premieres')]/../../../..//img"
        WebElement moviename = driver.findElement(By.xpath("//h2[contains(text(),'Premieres')]/../../../..//img"));
        System.out.println(moviename.getText());
        Thread.sleep(1000);
        //Get the element of these WebElements by getText method premieres.getText()
        WebElement movieLanguage = driver.findElement(By.xpath("//div[text()='English']"));
        System.out.println(movieLanguage.getText());

    }

    
}
