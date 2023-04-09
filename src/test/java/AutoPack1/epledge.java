package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class epledge {
    WebDriver driver;

    @Test(priority = 1)
    void InvokeChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void OpenUrl()
    {
        driver.get("https://www.ceopunjab.gov.in/AddePledge");
    }

    @Test(priority = 3)
    void names () throws InterruptedException {
        ArrayList<String> names = new ArrayList<String>();
//        names.add("Reshma Rani");
//        names.add("Dimple");
//        names.add("Kavita Devi");
        names.add("Daya Ram");
        names.add("Ramesh Kumar");
        names.add("Meena");
        names.add("Raj Kumar");
        names.add("Maya Devi");
        names.add("Parerna");
        System.out.println(names);
        for(int i =0;i<=names.size();i++)
        {
            driver.findElement(By.id("PersonName")).sendKeys(names.get(i));
            System.out.println(names.get(i));
            driver.findElement(By.xpath("(//div[@class='nice-select form-control'])[1]")).click(); // open district dropdown
            Thread.sleep(500);
            driver.findElement(By.xpath("//li[@data-value='10']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("(//div[@class='nice-select form-control'])[2]")).click(); // open AC dropdown
            Thread.sleep(500);
            driver.findElement(By.xpath("//li[@data-value='56']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("(//div[@class='nice-select form-control'])[3]")).click(); // open part dropdown
            Thread.sleep(500);
            driver.findElement(By.xpath("//li[text()='10 - Mandi Gobindgarh']")).click();
            Thread.sleep(1000);
         //   driver.findElement(By.tagName("body")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='Read e-Pledge']")).click(); // click on submit button
            Thread.sleep(56000);
            driver.findElement(By.xpath("//input[@value='I Pledge']")).click();
            Thread.sleep(3000);
            driver.navigate().refresh();
            Thread.sleep(3000);


        }
    }


}
