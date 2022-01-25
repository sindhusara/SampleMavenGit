package TestingSS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Locale;

public class SeleniumPractice {

    // change for GIT Learn

   // public static void main(String[] args)

      //  testng();
    @BeforeMethod
    public void BeforMethod()
    {

     System.out.println("Befor Method is executed");
    }

    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("After Method is executed");

    }

    @Test
    public void testng1() {

        System.setProperty("webdriver.chrome.driver", "/Users/sindhusmac/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);

        String Title = driver.getTitle();

        System.out.println("Tile of the page is " + Title);

        driver.quit();

    }
    @Test

    public void testng2()
    {

        System.setProperty("webdriver.chrome.driver", "/Users/sindhusmac/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);

        Actions acc = new Actions(driver);
        WebElement element = driver.findElement(webele12.PopUpLink);

        acc.moveToElement(element).build().perform();

        driver.findElement(webele12.SignInButton).click();
        driver.findElement(webele12.Username).sendKeys("sindhukaliappan@outlook.com");
        driver.findElement(webele12.UserNameContinue).click();
        driver.findElement(webele12.Password).sendKeys("Arulvarman2017");
        driver.findElement(webele12.Login).click();

          driver.quit();

    }
}









