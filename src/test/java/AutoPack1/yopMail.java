package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class yopMail {
    WebDriver driver;
    @Test(priority = 1)
    void InvokeChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void OpenUrl()
    {
        driver.get("https://yopmail.com/");
    }

    @Test(priority = 3)
    void enterEmail()
    {
        driver.findElement(By.id("login")).sendKeys("simtestipa");
        driver.findElement(By.id("refreshbut")).click();
    }

    @Test(priority = 4)
    void getOtp() throws InterruptedException {
        Thread.sleep(2000);
        driver.switchTo().frame("ifmail");
       String s = (driver.findElement(By.xpath("//p[contains(text(), 'Your verification token for Aawaz is')]")).getText());
       String[] text = s.split(" ");
        System.out.println(text[6]);
    }

}
