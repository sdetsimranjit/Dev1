package AutoPack1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;
public class MetaMask {
    WebDriver driver;

    @Test(priority = 0)
    void launchBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("D:\\ATR - 791\\Drive D\\MetaMask.crx"));
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WinHandel.get(0));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Get started']")).click();
        driver.findElement(By.xpath("//button[text()='I agree']")).click();
        driver.findElement(By.xpath("//button[@data-testid='create-wallet-button']")).click();
        driver.findElement(By.xpath("//input[@id='create-password']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//input[@id='confirm-password']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//div[@class='first-time-flow__checkbox']")).click();
        driver.findElement(By.xpath("//button[text()='Create']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Next']")).click();
    }

    @Test(priority = 1)
    void getMnemonic() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Click here to reveal secret words']")).click();
        String text = driver.findElement(By.xpath("//div[@class='reveal-seed-phrase__secret-words notranslate']")).getText();
        String[] strArr = null;
        strArr = text.split(" ");
        driver.findElement(By.xpath("//button[text()='Next']")).click();
        for (int j = 0; j < strArr.length; j++) {
            driver.findElement(By.xpath("//div[@class = 'btn-secondary notranslate confirm-seed-phrase__seed-word confirm-seed-phrase__seed-word--sorted' and contains (text(), '" + strArr[j] + "')]")).click();
        }
        driver.findElement(By.xpath("//button[text()='Confirm']")).click();
        driver.findElement(By.xpath("//button[text()='All done']")).click();
    }


}