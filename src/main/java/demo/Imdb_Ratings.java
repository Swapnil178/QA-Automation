package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imdb_Ratings {
    WebDriver driver;

    public Imdb_Ratings()
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

    public void ImdbRatings()
    {
        // "Navigate to URL https://www.imdb.com/chart/top https://www.imdb.com/chart/top"
        driver.findElement(By.xpath("https://www.imdb.com/chart/top https://www.imdb.com/chart/top"));
        // Find gthe highest rated movie Using Locator "XPath" //h3[contains(text(),'The Shawshank Redemption')]
        WebElement Highestrated = driver.findElement(By.xpath("//h3[text()='1. The Shawshank Redemption']"));
        System.out.println(" Highest rated movie : ");
        System.out.println(Highestrated.getText());
        // Total no. of movies included in the table Using Locator "XPath" //*[@id="__next"]/main/div/div[3]/section/div/div[2]/div/ul/li
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li"));
        System.out.println();
        System.out.println(" Total count of movies in the table: "+ list.size());
        System.out.println();
        // "Click on drop down and select 'Release Date'Using select class Using Locator ""XPath"" //select[@id='sort-by-selector']"
         WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='sort-by-selector']"));
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Release date");
        // Finding the oldest movies Using Locator "XPath" //*[@id="__next"]/main/div/div[3]/section/div/div[2]/div/ul/li[250]
         WebElement oldestmovie = driver
                .findElement(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[250]"));
        System.out.println("oldest movie on the list");
        System.out.println(oldestmovie.getText());
        // Finding the recent movie on the list Using Locator "XPath" //*[@id="__next"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]
        WebElement Most_Recent_Movie = driver
                .findElement(By.xpath("//*[@id='__next']/main/div/div[3]/section/div/div[2]/div/ul/li[1]"));
        System.out.println("most recent movie on the list");
        System.out.println(Most_Recent_Movie.getText());
        System.out.println();
        // Click on drop down and select 'Number of Rating' Using Locator "XPath" //*[@id="__next"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]
        dropdown.selectByVisibleText("Number of ratings");

        WebElement MostUserRating = driver
                .findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[3]/section/div/div[2]/div/ul/li[1]"));
        System.out.println("movie has the most user ratings");
        System.out.println(MostUserRating.getText());
        System.out.println();
    }
}