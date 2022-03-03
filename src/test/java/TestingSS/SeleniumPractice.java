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
    WebDriver driver = null;

    @BeforeMethod
    public void BeforMethod() {

        System.setProperty("webdriver.chrome.driver", "/Users/sindhusmac/Downloads/chromedriver");
        System.out.println("Befor Method is executed");
    }

    @AfterMethod
    public void AfterMethod() {
        driver.close();
        driver.quit();
        System.out.println("After Method is executed");

    }

    @Test
    public void testng1() throws IOException {

        //System.setProperty("webdriver.chrome.driver", "/Users/sindhusmac/Downloads/chromedriver");
        driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);

        String Title = driver.getTitle();

        System.out.println("Tile of the page is " + Title);


        TakesScreenshot scrshot = (TakesScreenshot) driver;

        File srcfile = scrshot.getScreenshotAs(OutputType.FILE);

        File destfile = new File("/Users/sindhusmac/Desktop/SampleMavenProject/Screenshots/Error.png");

        FileUtils.copyFile(srcfile, destfile);

        Assert.assertEquals(Title, "Amazon.com. Spend less. Smile more.");
    }

    @Test

    public void testng2() {
        try {

            driver = new ChromeDriver();

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
            System.out.println("samplejenkins3");

        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }

    }

    @Test()
    public void testng3() {
        driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);
        String LoggedName1 = driver.findElement(webele12.LoggedUserName).getText();

        System.out.println(LoggedName1);
        Assert.assertEquals(LoggedName1, "Hello, Sign in");


    }

    @Test()
    public void testng4() throws InterruptedException {

        driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);

        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        //  driver.findElement(By.id("Back to top")).click();
        //   driver.manage().timeouts().wait(100);
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));


    }

    @Test()
    public void testng5()
    {
        driver = new ChromeDriver();

        WebElements1 webele12 = new WebElements1();
        driver.get(webele12.BaseURL);
        driver.findElement(webele12.Dropdownlist).click();
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[1]/div/div/select/option[13]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")).sendKeys("courses in amazon");
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input")).sendKeys(Keys.ENTER);
        //driver.manage().wait(5000);

    }
}








