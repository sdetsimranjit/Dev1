package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoClass1 {
    WebDriver driver;
    @Test
    void openBrowser(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
   }
//   @Test(priority = 1)
//    void url1() throws InterruptedException {
//        driver.get("https://www.google.com");
//       Thread.sleep(1000);
//   }
    @Test(priority = 1)
    void OpenLink() throws InterruptedException {
        driver.get("https://exchange.stage-coingeb.com/");
        Thread.sleep(1000);
    }
    @Test(priority = 3)
    void getTitle() throws InterruptedException {
      String a =   driver.getTitle();
        System.out.println("Title is "  +a);
      String b = driver.getCurrentUrl();
        System.out.println("Url is" +b );
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)", "");
    }

}

