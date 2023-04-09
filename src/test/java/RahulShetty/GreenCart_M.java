package RahulShetty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GreenCart_M {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        String[] vegcol = {"Cucumber - 1 Kg", "Tomato - 1 Kg", "Capsicum", "Potato - 1 Kg", "Corn - 1 Kg"};
        // String vegName = "Brinjal - 1 Kg";
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(2000);
        addVeg(driver, vegcol);

    }

    public static void addVeg(WebDriver driver,  String[] vegcol)
    {
        List<WebElement> productsName = driver.findElements(By.xpath("//h4[@class='product-name']"));
        for (int j=0;j< vegcol.length;j++)
        {
            for (int i = 0; i < productsName.size(); i++) {
                String name = productsName.get(i).getText();
                //   System.out.println(i + ". " + name);
                if (name.contains(vegcol[j])) {
                    //System.out.println(i + " in if");
                    int n = i + 1;
                    // System.out.println(driver.findElements(By.xpath("(//div[@class='product-action'])[" + n + "]")));
                    driver.findElement(By.xpath("(//div[@class='product-action'])[" + n + "]")).click();
                    // driver.findElement(By.xpath("(//div[@class='product-action'])'"+[i]+''").click();
                    //driver.findElements(By.xpath("//button[@type='button']")).get(i + 1).click();

                }


            }

        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click(); // Click on Cart
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click(); // Click on proceed to checkout
        driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy"); //Enter the promo code
        driver.findElement(By.cssSelector("button.promoBtn")).click(); // CLick on the apply button
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText()); // print the info text
        WebDriverWait w = new WebDriverWait(driver,  Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));



    }
    }
