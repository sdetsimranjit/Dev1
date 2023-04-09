package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownsPractice {
    WebDriver driver;

    @Test(priority = 1)
    void InvokeChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void DropDowmsPractice ()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement StaticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(StaticDropdown);
        System.out.println(dropdown.getOptions());
    }
}
