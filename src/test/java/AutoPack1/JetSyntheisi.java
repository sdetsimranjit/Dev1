package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JetSyntheisi {
    WebDriver driver;
    @Test(priority = 1)
    void InvokeChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void OpenUrl() throws InterruptedException {
        driver.get("https://qa.jetnft.in/signup");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void EnterDetails()
    {
        driver.findElement(By.id("email")).sendKeys("simtest@yopmail.com");
    }
}
