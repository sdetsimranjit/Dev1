package AutoPack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestField {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-stage.cupchairs.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='headerLinks btn login nav-link']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mohit.sharma+1@antiersolutions.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin@1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        driver.navigate().to("https://qa-stage.cupchairs.com/nft-info/640");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btmButton>button")).click();
//        Thread.sleep(2000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1700)", "");
//        Thread.sleep(2000);
//       // driver.findElement(By.xpath("body")).click();
//        driver.findElement(By.xpath("(//h4[contains(text(), 'Entertainment')])[2]")).click();
//        Thread.sleep(1000);
//        System.out.println("Css Text is:: " + driver.findElement(By.cssSelector(".tab-content>div>div>div>div>div>div:nth-child(6)>div>div:nth-child(3)>h6")).getText());



    }


}
