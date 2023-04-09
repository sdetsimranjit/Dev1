package AutoPack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MakeMyTrip {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(2000);
        driver.findElement(By.tagName("body")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("fromCity")).click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Chandi");
        Thread.sleep(1000);
       // driver.findElement(By.cssSelector(".react-autosuggest__suggestions-list>li:nth-child(1)")).click();
        driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText' and contains(text(), 'Chandigarh')]")).click();
        driver.findElement(By.cssSelector("label[for='toCity']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".react-autosuggest__input.react-autosuggest__input--open")).sendKeys("Delhi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@class='font14 appendBottom5 blackText' and text()='New Delhi, India']")).click();
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector(".fsw_inputBox.dates.inactiveWidget")).click();
        Thread.sleep(2000);
       driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--today']")).click();


    }
}
