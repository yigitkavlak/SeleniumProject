import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","/Users/mrk/Desktop/geckodriver.exe");

        //Create firefox driver's instance
        WebDriver driver = new FirefoxDriver();

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
        passwordEdittext.sendKeys("Kavlak12.");
        System.out.println("Password input filling");
        Thread.sleep(5000);

        WebElement loginButtonSecond = driver.findElement(By.id("rcmloginsubmit"));
        loginButtonSecond.click();
        System.out.println("Login button clicking");
        Thread.sleep(5000);

        String expectedUrl = "https://webmailstudent.cankaya.edu.tr/?_task=mail&_mbox=INBOX";

        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl,"Page url doesnt match");

        System.out.println("The page url has been successfully verified");

        System.out.println("User logged in successfully");

        //Sleep 10 seconds before quit
        Thread.sleep(10000);
        driver.quit();
    }
}
