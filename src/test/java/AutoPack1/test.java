package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class test {
    WebDriver driver;

    @Test (priority = 1,enabled = false)
    void SetupWebDriver ()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @Test (priority = 2)
//    void openWebsites () throws InterruptedException {
//        driver.get("https://www.facebook.com");
//        Thread.sleep(2000);
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://www.amazon.com");
//        Thread.sleep(2000);
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://www.apple.com/in");
//        Thread.sleep(2000);
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://www.netflix.com/in");
//        Thread.sleep(2000);
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://www.google.com");
//        Thread.sleep(2000);
//    }
    @Test (priority = 2)
    void runIterator () throws InterruptedException {
        Set<String> set = driver.getWindowHandles();
//        Iterator<String> itr = set.iterator();
//        //String handling = itr.next();
//        driver.switchTo().window(itr.next());
//        Thread.sleep(1000);
//        driver.switchTo().window(itr.next());
//        Thread.sleep(1000);
//        driver.switchTo().window(itr.next());
//        Thread.sleep(1000);
//        driver.switchTo().window(itr.next());
//        Thread.sleep(1000);
//        driver.switchTo().window(itr.next());
//        Thread.sleep(1000);
//        itr = set.iterator();
//        driver.switchTo().window(itr.next());
//        driver.switchTo().window(itr.next());
//        driver.findElement(By.)
        ChromeOptions options = new ChromeOptions();
//This line of code is used to remove the alert i.e. "Chrome is being used by automation tool"
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//This line of code is used to remove the alert i.e. "Chrome is being used by automation tool"
        options.addExtensions(new File("D:\\MetaMask.crx"));
        driver = new ChromeDriver(options);
        Thread.sleep(1000);
        Set<String> s = driver.getWindowHandles();
        Iterator<String> nitr = set.iterator();
        driver.switchTo().window(nitr.next());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class = 'button btn--rounded btn-primary first-time-flow__button']")).click();



    }

}



