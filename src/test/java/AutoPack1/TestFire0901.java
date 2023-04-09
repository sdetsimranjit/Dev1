package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestFire0901 {
    WebDriver driver;
    @Test(priority = 1)
    void InvokeChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test ( priority = 2)
    void OpenWebsite() throws InterruptedException {
        driver.get("https://explorer.5ire.network/");
        Thread.sleep(7000);
    }

    @Test(priority =  3)
            void openChatBox() throws InterruptedException {
        driver.findElement(By.xpath("//iframe[@title='Button to launch messaging window']")).click();
        Thread.sleep(3000);
    }
    @Test(priority = 4)
    void clickOnButton() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Messaging window']")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),'Technical Help')]")).click();
    }
    @Test(priority = 5)
    void SendMessage()
    {
        driver.findElement(By.xpath("//textarea[@class='StyledTextInput-sc-k12n8x-0 sc-1vpqusk-2 dAjqOh StyledTextarea-sc-wxschl-0 zLLnd']")).sendKeys("Simran this side");
        driver.findElement(By.xpath("//button[@class='sc-htpNat sc-1vpqusk-1 hGYgDC sc-EHOje jJOPWF']")).click();
    }
}




