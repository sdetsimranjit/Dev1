package RahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AssignMent3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/"); // Go to the practice page
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy"); // Enter Username
        driver.findElement(By.id("password")).sendKeys("learning"); // Enter Password
        driver.findElement(By.cssSelector("input[value='user']")).click(); // Click on User
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); // Add Explicit wait for OKAY wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click(); // Click on Okay

        // Select a Value from dropdown
        WebElement dropdown = driver.findElement(By.cssSelector("select.form-control"));
        dropdown.click();
        Select s = new Select(dropdown);
        s.selectByVisibleText("Consultant"); // Select consultant from dropdown

        driver.findElement(By.id("terms")).click(); // Accepts the T&C
        driver.findElement(By.id("signInBtn")).click(); // Click on the signin button
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.sr-only"))); // Wait until we move to the next page
        List <WebElement>items = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for(WebElement i : items)
        {
             i.click();
        }
        driver.findElement(By.cssSelector("li[class='nav-item active']")).click();
    }
}