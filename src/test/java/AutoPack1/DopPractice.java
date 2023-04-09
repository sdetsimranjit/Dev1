package AutoPack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DopPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        driver.findElement(By.id("autosuggest")).sendKeys("au");
//        Thread.sleep(2000);
//        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
//        for (WebElement option : options)
//        {
//            if(option.getText().equalsIgnoreCase("Macau"))
//            {
//                option.click();
//                break;
//            }
//        }
//
//        WebElement drop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//        Select dropdown = new Select(drop);
//      //  System.out.println(dropdown.getOptions(drop));
//        dropdown.selectByIndex(2);
//        System.out.println(dropdown.getFirstSelectedOption().getText());
//        dropdown.selectByVisibleText("USD");
//        System.out.println(dropdown.getFirstSelectedOption().getText());

        driver.get("https://www.spicejet.com/");
        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-n6v787 r-1ozqkpa' and text()='Senior Citizen']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='r-1862ga2 r-1loqt21 r-1enofrn r-tceitz r-u8s1d css-76zvg2' and text()='From']")).click();
        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and text()='Chandigarh']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79' and text()='Goa']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".css-1dbjc4n.r-1awozwy.r-19m6qjp.r-156aje7.r-y47klf.r-1phboty.r-1d6rzhh.r-1pi2tsx.r-1777fci.r-13qz1uu")).click();

        driver.findElement(By.xpath("//div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e' and text() = 'Passengers']")).click();
        Thread.sleep(1000);
        int i=1;
        while (i<5) {
            driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
            i++;
        }
    }
}
