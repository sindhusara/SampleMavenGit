package TestingSS;

import net.bytebuddy.build.Plugin;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


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
    public void AfterMethod() {
        System.out.println("After Method is executed");

    }

    @Test
    public void testng1() throws IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/sindhusmac/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);

        String Title = driver.getTitle();

        System.out.println("Tile of the page is " + Title);


        TakesScreenshot scrshot = (TakesScreenshot)driver;

        File srcfile = scrshot.getScreenshotAs(OutputType.FILE);

        File destfile = new File("/Users/sindhusmac/Desktop/SampleMavenProject/Screenshots/Error.png");

        FileUtils.copyFile(srcfile,destfile);

        Assert.assertEquals(Title,"Amazon.com. Spend less. Smile");

        driver.quit();

    }


    @Test

    public void testng2() {
        try {
            System.setProperty("webdriver.chrome.driver", "/Users/sindhusmac/Downloads/chromedriver");
            WebDriver driver = new ChromeDriver();

            WebElements1 webele12 = new WebElements1();
            driver.get(webele12.BaseURL);

            Actions acc = new Actions(driver);
            WebElement element = driver.findElement(webele12.PopUpLink);

            acc.moveToElement(element).build().perform();

            driver.findElement(webele12.SignInButton).click();
            driver.findElement(webele12.Username).sendKeys("Sindhukaliappan@gmail.com");
            driver.findElement(webele12.UserNameContinue).click();
            driver.findElement(webele12.Password).sendKeys("Arul");
            driver.findElement(webele12.Login).click();
            String SignInTitle = driver.getTitle();

            System.out.println(SignInTitle);
            Assert.assertTrue(true, SignInTitle);
            System.out.println("samplejenkins2");
            driver.quit();
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }

    }

    @Test()
    public void testng3(){

        System.setProperty("webdriver.chrome.driver", "/Users/sindhusmac/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);
        String LoggedName1 = driver.findElement(webele12.LoggedUserName).getText();

        System.out.println(LoggedName1);
        Assert.assertEquals(LoggedName1,"Hello, Sign in");
        driver.quit();

    }

    @Test()
    public void testng4() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sindhusmac/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);

        driver.manage().window().maximize();

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1500)");
      //  driver.findElement(By.id("Back to top")).click();
     //   driver.manage().timeouts().wait(100);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
        driver.close();

    }
    }









