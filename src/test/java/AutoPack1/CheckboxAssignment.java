package AutoPack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.tagName("body")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".fsw_inputBox.dates.inactiveWidget")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".class=DayPicker-Day.DayPicker-Day--selected.DayPicker-Day--today")).click();
//        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        System.out.println("Number of checkboxes are:: " + driver.findElements(By.xpath("//div[@id='checkbox-example'] //input[@type='checkbox']")).size());



//        driver.findElement(By.id("checkBoxOption1")).click();
//        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
//        driver.findElement(By.id("checkBoxOption1")).click();
//        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());


    }
}
