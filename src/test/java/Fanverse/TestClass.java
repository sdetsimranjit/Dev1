//package Fanverse;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WindowType;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//
//public class TestClass {
//    WebDriver driver;
//    @Test(priority = 1)
//    public void openBrowser() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.get("https://uat.fan-verse.io/home");
//        Thread.sleep(3000);
//    }
//    @Test (priority = 2)
//            driver.findElement(By.xpath("//button[@text='Login']")).click(); // click on login Button
//        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(generatedString + "@yopmail.com"); //Enter Email
//        driver.findElement(By.xpath("//button[@class='w3a-button w-full']")).click(); // submit
//        driver.switchTo().newWindow(WindowType.TAB); // open new tab
//        driver.get("https://yopmail.com/"); // open yopmail
//        driver.findElement(By.id("login")).sendKeys(generatedString);
//        driver.findElement(By.id("refreshbut")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.id("refresh")).click(); // click on the refresh button
//        driver.switchTo().frame("ifmail");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[text()='Approve login request']")).click();
//    ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(WinHandel.get(0));
//
//}