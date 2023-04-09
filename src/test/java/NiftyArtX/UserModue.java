package NiftyArtX;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserModue {

    WebDriver driver;
    String firstName = "Simranjit";
    String lastName = "Singh";
    String userNamwe = "sim";
    String emaail = "Simtest@yopmail.com";
    String mobileNumber = "7298470007";
    String password = "Admin@123";
    @Test(priority = 0)
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://stage.niftyartx.com/");
        Thread.sleep(3000);
    }

//    @Test(priority = 1)
//    public void signUp() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(firstName); //Enter Firstname
//        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lastName); // Enter Lastname
//        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userNamwe); // Enter Username
//        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(emaail); // Enter email
//        driver.findElement(By.cssSelector("input[name='mobilenumber']")).sendKeys(mobileNumber); // Enter Mobile Number
//        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password); // Enter Password
//        driver.findElement(By.cssSelector("input[name='cpassword']")).sendKeys(password); // Confirm Password
//    }

    @Test (priority = 1)
    public void webElements() throws InterruptedException {
        driver.findElement(By.linkText("Sign Up")).click(); // Go to the signup page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement Firstname =  driver.findElement(By.cssSelector("input[placeholder='First Name']"));
//       WebElement Lastname = driver.findElement(By.cssSelector("input[name='lastname']"));
//       WebElement Username = driver.findElement(By.cssSelector("input[name='username']"));
//       WebElement Email = driver.findElement(By.cssSelector("input[name='email']"));
//       WebElement MobileNumber = driver.findElement(By.cssSelector("input[name='mobilenumber']"));
//       WebElement Password = driver.findElement(By.cssSelector("input[name='password']"));
//       WebElement ConfirmPassword = driver.findElement(By.cssSelector("input[name='cpassword']"));
       // ArrayList<WebElement> ele = new ArrayList<WebElement>();
        String [] fill = {" ", "qwertyuiopasdfgh", "12346 "};
        //driver.findElement(By.tagName("body")).click();
        Thread.sleep(1500);
       // driver.findElement(By.xpath("//button[@type='submit']")).click();
        for(int i=0; i<=fill.length; i++)
        {

            Firstname.sendKeys(fill[i]);
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollBy(0,5000)", "");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(500);
            System.out.println("Validation at " + fill[i] + "is " + driver.findElement(By.cssSelector("p.error_message")).getText());
            Firstname.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); // clear the Name field

        }
    }
}