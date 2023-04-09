package AutoPack1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AAWAZSignUP {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        for (int i=1;i<=10;i++) {
            driver.get("https://stage.tradeaawaz.com/register");
            String email = "aawazdemo" + i + "@yopmail.com";
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@placeholder='Robert']")).sendKeys("Simranjit"); //FirstName
            driver.findElement(By.xpath("//input[@placeholder='Kriyo']")).sendKeys("Test"); //LastName
            driver.findElement(By.xpath("//input[@placeholder='9123456789']")).sendKeys("7298470007"); //Phone Number
            driver.findElement(By.xpath("//input[@placeholder='aawaz@gmail.com']")).sendKeys(email); // email
            driver.findElement(By.xpath("(//input[@placeholder='****************'])[1]")).sendKeys("Admin@123"); //password
            driver.findElement(By.xpath("(//input[@placeholder='****************'])[2]")).sendKeys("Admin@123"); // confirm passowrd
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(300,400)", "");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(5000);
            System.out.println("Account Emails are:: " + email);
            System.out.println("Test");


            // This is the changes made in the downloaded code
        }
    }
}
