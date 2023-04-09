package RahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public interface S7A2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@minlength='2']")).sendKeys("Simranjit Singh"); // Enter the name
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Simranji1997@gmail.com"); // Enter email
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Admin@123"); // Enter Password
        driver.findElement(By.id("exampleCheck1")).click(); // Click checkbox

        //Select dropdown
        WebElement dd = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(dd);
        dropdown.selectByIndex(0);

        driver.findElement(By.id("inlineRadio2")).click(); // Employment status
        driver.findElement(By.xpath("//input[@min='1000-01-01']")).sendKeys("10081997"); // enter dob
        driver.findElement(By.xpath("//input[@type='submit']")).click(); // click on submit

        //Get the text of success message
        System.out.println(driver.findElement(By.xpath("//div[strong]")).getText());

    }
}
