package AutoPack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PeerClub {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://swap.peerclub.com/landing");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='styles_button__1RkCe']")).click();
        driver.findElement(By.xpath("//a[@class='styles_button_blue__YwyRu']")).click();
        driver.findElement(By.xpath("//div[@class=' css-1tv2utx']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("react-select-4-option-119")).click();

    }
}
