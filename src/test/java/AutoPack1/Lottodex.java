package AutoPack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Lottodex {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stage.lottdex.com/signup");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".selected-flag")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@class='search-box']")).sendKeys("Jam");
       // Thread.sleep(2000);
        List<WebElement> country = driver.findElements(By.xpath("//span[@class ='country-name']"));
        System.out.println("c" + country);
        // Thread.sleep(1000);
        System.out.println("Size is:: " + country.size());
      //  for(int i=0;i<=country.size();i++)
           for(WebElement select : country)
        {
            String text = select.getText();
            System.out.println("Text is:: " + text);
            Thread.sleep(1000);
            if(text.equals("Jamaica"))
            {
                select.click();
                //break;
            }
        }
     //   driver.findElement(By.xpath("//li[@class='country'] //span[@class='country-name' and text()='Jamaica']")).click();
    }
}
