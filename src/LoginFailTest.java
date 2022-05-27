import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginFailTest {
    @Test
    public void loginFailTest() throws InterruptedException {
        //System.setProperty("webdriver.gecko.driver","/Users/mrk/Desktop/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "/Users/mrk/Desktop/chromedriver.exe");

        //Create firefox driver's instance
        //WebDriver driver = new FirefoxDriver();

        //Create chrome driver's instance
        WebDriver driver = new ChromeDriver();

        //Set implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://webmailstudent.cankaya.edu.tr");

        Thread.sleep(5000);

        WebElement emailEdittext = driver.findElement(By.id("rcmloginuser"));
        emailEdittext.clear();
        emailEdittext.sendKeys("c2171207");
        System.out.println("UserId input filling");
        Thread.sleep(5000);

        WebElement passwordEdittext = driver.findElement(By.id("rcmloginpwd"));
        passwordEdittext.clear();
        passwordEdittext.sendKeys("Kavlak121.");
        System.out.println("Password input filling");
        Thread.sleep(5000);

        WebElement loginButtonSecond = driver.findElement(By.id("rcmloginsubmit"));
        loginButtonSecond.click();
        System.out.println("Login button clicking");
        Thread.sleep(5000);

        String expectedUrl = "https://webmailstudent.cankaya.edu.tr/?_task=mail&_mbox=INBOX";

        String actualUrl = driver.getCurrentUrl();

        Assert.assertNotSame(actualUrl, expectedUrl, "Page url matches. User logged in successfully");

        System.out.println("Page url doesnt match. User failed to logged in");

        System.out.println("Fail test passed");

        //Sleep 10 seconds before quit
        Thread.sleep(10000);
        driver.quit();
    }
}
