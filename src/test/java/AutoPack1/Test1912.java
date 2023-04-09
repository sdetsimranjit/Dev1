package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test1912 {
    WebDriver driver;

    @Test(priority = 1)
    void InvokeChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    void OpenWebsite() throws InterruptedException {
        driver.get("https://exchange.stage-coingeb.com/login");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    void Email() {
        driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("shiva.mahajan@antiersolutions.com");
    }

    @Test(priority = 4)
    void Password() {
        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("Test@123");
    }

    @Test(priority = 5)
    void Captcha() throws InterruptedException {
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        Thread.sleep(15000);
        driver.switchTo().parentFrame();
    }

    @Test(priority = 6)
    void LoginButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class = 'ui primary button loginUIButton']")).click();
        Thread.sleep(2000);
    }

//    @Test(priority = 7)
//    void GetText() throws InterruptedException {
//        Thread.sleep(2000);
//        WebElement text = driver.findElement(By.xpath("//div[@class='copy_iconinValue']/p"));
//        String s = text.getText();
//        System.out.println("Getted Text is:: " + s);
//    }

//    @Test(priority = 8)
//    void CopyText() throws IOException, UnsupportedFlavorException, InterruptedException {
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[@class='copy_iconinValue']")).click();
//        String cs = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
//        System.out.println("Copied Text is:: " + cs);
//        String otpKeyStr = cs; // <- this 2FA secret key.
//        Totp totp = new Totp(otpKeyStr);
//        String twoFactorCode = totp.now();
//        driver.findElement(By.xpath("//input[@placeholder='Code']")).sendKeys(twoFactorCode);
//        Thread.sleep(1000);
//        //  driver.findElement(By.xpath("//button[@class='ui button resetButton ' and text()='Enable']")).click();
//        driver.findElement(By.xpath("//button[@class='ui button resetButton grayBtn']")).click();
//        Thread.sleep(1000);
//
//    }

    @Test(priority = 7)
    void NaviGateToExchange() throws InterruptedException {
        driver.navigate().to("https://exchange.stage-coingeb.com/trading/sxpbtc");
        Thread.sleep(2000);
      //  System.out.println("Available Balance is:: " + driver.findElement(By.xpath("(//td[@data-th='Available balance ']/span)[1]")).getText());
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(300,400)", "");

    }

    @Test (priority = 8)
    void price() throws IOException, InterruptedException {
        File src = new File("D:\\Test.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheet("Sheet1");
        String data;
        double intdata;
        int row_count = sheet.getPhysicalNumberOfRows(); //counting the Number of rows
        XSSFRow row = sheet.getRow(0);
        int col_count = row.getPhysicalNumberOfCells();
        intdata = sheet.getRow(1).getCell(0).getNumericCellValue();
        System.out.println("The value of cell 01 is:: " + intdata);
        String input = String.valueOf(intdata);
        driver.findElement(By.xpath("//input[@name='price']")).sendKeys(input);
        intdata = sheet.getRow(1).getCell(1).getNumericCellValue();
        System.out.println("The value of cell 11 is:: " + intdata);
        input = String.valueOf(intdata);
        driver.findElement(By.xpath("//input[@name='buy_amount']")).sendKeys(input);
        driver.findElement(By.xpath("//button[@class='ui button resetButton buyButton']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[@class='Toastify__toast-body']")).getText());
    }
//    @Test(priority = 11)
//    void enterPrice()
//    {
//        driver.findElement(By.xpath("//input[@name='price']")).sendKeys(data);
//    }



//
    @Test(priority = 10)
    void GetAvailableBalance() {
        for (int i = 1; i <= 16; i++) {

            WebElement name = driver.findElement(By.xpath("(//td[@data-th='Name'])["+i+"]"));
            WebElement element =  driver.findElement(By.xpath("(//td[@data-th='Available balance '])["+i+"]"));
            String cname  = name.getText();
            Actions actions = new Actions(driver);
            WebElement table = driver.findElement(By.xpath("//div[@class='oveflowAutoStyle']"));
            actions.scrollToElement(element).perform();
            actions.moveToElement(element).perform();
            System.out.println("Balance for " + cname + " is "  + driver.findElement(By.xpath("(//td[@data-th='Available balance ']/span)["+i+"]")).getText());


        }
    }

}

