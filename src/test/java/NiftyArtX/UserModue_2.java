package NiftyArtX;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserModue_2 {
    WebDriver driver;
    @Test(priority = 0)
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://stage.niftyartx.com/signup");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(300,300)", "");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test (priority = 1)
    public void firstNameValidations() throws InterruptedException {
        String [] fill = {" ", "qwertyuiopasdfgh", "12346 ", "Simran Jit", ".@$", "Simranjit"};
        WebElement Firstname =  driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        System.out.println("First Name Field Validations");
        for(int i=0; i<fill.length; i++)
        {
            Firstname.sendKeys(fill[i]);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(500);
            System.out.println("Validation at " + fill[i] + " is:- " + driver.findElement(By.cssSelector("p.error_message")).getText());
            if(i< fill.length-1) {
                Firstname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); // clear the Name field
            }
            }
        System.out.println(" --------------------------- Done with First Name -----------------------------");
    }

    @Test (priority = 2)
    public void LastNameValidations() throws InterruptedException {
        String [] fill = {" ", "qwertyuiopasdfgh", "12346 ", "Simran Jit", ".@$", "Simranjit"};
        WebElement Lastname =  driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        System.out.println("Last Name Field Validations");
        for(int i=0; i<fill.length; i++)
        {
            Lastname.sendKeys(fill[i]);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(500);
            System.out.println("Validation at " + fill[i] + " is:- " + driver.findElement(By.xpath("(//p[@class=\"error_message\"])[2]")).getText());
            Lastname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); // clear the Name field
        }
        System.out.println(" --------------------------- Done with Last Name -----------------------------");
    }

}