//package AutoPack1;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//
//public class aawazlogin {
//    WebDriver driver;
//    String email = "Simtestnew6@yopmail.com";
//    String Password = "Admin@123";
//
//    @Test(priority = 1)
//    void InvokeChrome() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//    }
//
//    @Test(priority = 2)
//    void OpenUrl() throws InterruptedException {
//        driver.get("https://stage.tradeaawaz.com/");
//        Thread.sleep(2000);
//    }
//
//    @Test(priority = 3)
//    void EnterDetails() {
//        driver.findElement(By.id("email")).sendKeys(email); //Enter email
//        driver.findElement(By.id("password")).sendKeys(Password); //Enter Password
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//    }
//
//    @Test(priority = 4)
//    void verify_code() throws InterruptedException {
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://yopmail.com/en/");                                      //yopmail.com
//        driver.findElement(By.id("login")).sendKeys(email);
////        ==========
////        driver.findElement(By.id("login")).sendKeys("lottdex");
//        driver.findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
//        Thread.sleep(5000);
//        driver.switchTo().frame("ifmail");
//        String s = (driver.findElement(By.xpath("//p[contains(text(), 'Your verification token for Aawaz is')]")).getText());
//        String[] text = s.split(" ");
//        System.out.println(text[6]);
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());                // Store all currently open tabs in tabs
//        System.out.println(tabs.size());                                                         // total tab currently open
//        driver.switchTo().window(tabs.get(0));
//        Thread.sleep(3000);
//        driver.findElement(By.id("aebef08e-0380-4fda-93e4-ff3c2783508b-0")).sendKeys("123654");
//    }
//
//}
//
//
