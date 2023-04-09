package BitbubbleMerchant;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignUp {
    WebDriver driver;
    String date = "3001";
    String email = "simtestnew"+date+"@yopmail.com";

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

    @Test (priority = 3)
    void goToSignUpPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
    }

    @Test ( priority = 4)
    void CreateBitBubbleAccount () throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@Placeholder='Email']")).sendKeys(email); // enterEmail
        driver.findElement(By.xpath("//input[@Placeholder='Password']")).sendKeys("Admin@123"); // enterPassword
        driver.findElement(By.xpath("//input[@Placeholder='Confirm Password']")).sendKeys("Admin@123"); // confirmPassword
        driver.findElement(By.xpath("//input[@type='checkbox']")).click(); // Agree T&C
        driver.findElement(By.xpath("//button[@type='submit']")).click(); // Click on Submit button
    }

    @Test ( priority = 5)
    void openNewTab () throws InterruptedException {
        Thread.sleep(5000);
       driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+ "t");


    }

}
