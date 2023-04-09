package BitbubbleMerchant;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LogIn {
    WebDriver driver;
    String date = "3001";
    String email = "simtest1"+date+"@yopmail.com";

    @Test(priority = 1)
    void InvokeChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void OpenUrl()
    {
        driver.get("https://merchant.stage-bitbubble.xyz/");
    }

    @Test(priority = 3)
    void EnterDetails()
    {
        driver.findElement(By.xpath("//input[@placeholder='Email ID']")).sendKeys("jagub@yopmail.com"); //Enter Email
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Admin@123"); //Enter Password
        driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Test(priority = 4)
    void  byPass2fa ()
    {

    }
}
