package Fanverse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TT2 {
    WebDriver driver;
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();
    String generatedString = "kiowpxbpfx";
    String BuyerEmail = "Simtest@yopmail.com";
//    String generatedString = random.ints(leftLimit, rightLimit + 1)
//            .limit(targetStringLength)
//            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//            .toString();

    @Test(priority = 1)
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://uat.fan-verse.io/home");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void Login() throws InterruptedException {
        driver.findElement(By.xpath("//button[@text='Login']")).click(); // click on login Button
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(generatedString + "@yopmail.com"); //Enter Email
        driver.findElement(By.xpath("//button[@class='w3a-button w-full']")).click(); // submit
        driver.switchTo().newWindow(WindowType.TAB); // open new tab
        driver.get("https://yopmail.com/");
        driver.findElement(By.id("login")).sendKeys(BuyerEmail);
        driver.findElement(By.id("refreshbut")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("refresh")).click(); // click on the refresh button
        driver.switchTo().frame("ifmail");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Approve login request']")).click();
        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WinHandel.get(0));
        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='textSection']"));
        //   Thread.sleep(9000);
    }

//    @Test(priority = 3)
//    public void BuyNFT() throws InterruptedException {
//        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("NFT 1 "); // Search the NFT
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//h3[@class='cardCollectionStyle__details__creatorName']")).click(); // Click on NFT
//        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//button[@text='Buy Now']")).click(); // Click on Buy Now
//        driver.findElement(By.xpath("//button[@text='Buy']")).click(); // Click on Buy from listings
//        Thread.sleep(1000);
//        String winHandleBefore = driver.getWindowHandle();
//        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click(); // Click on complete purchase
//        Thread.sleep(2000);
//        // Click on the button that opens the new window
//      //  driver.findElement(By.id("button")).click();
//
//// Get the handle of the current window
//        Thread.sleep(2000);
//        for(String winHandle : driver.getWindowHandles()){
//            driver.switchTo().window(winHandle);
//        }
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
//        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(WinHandel.get(0));
//        System.out.print(driver.findElement(By.xpath("//div[@class='textSection']")).getText());
//
////        String winHandleBefore = driver.getWindowHandle();
////        for(String winHandle : driver.getWindowHandles()){
////            System.out.println( winHandle);
////            driver.switchTo().window(winHandle);
////        }
////        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
////        driver.findElement(By.id("confirm-btn")).click();
////        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
////        driver.switchTo().window(WinHandel.get(0));    }
//
////    @Test(priority = 3)
////    public void logOut () throws InterruptedException {
////        Thread.sleep(2000);
////        driver.findElement(By.xpath("//button[@text='Logout']")).click();
////     //   driver.navigate().refresh();
////    }
////
////    @Test(priority = 4)
////    public void LoginBuyer() throws InterruptedException {
////        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////        driver.findElement(By.xpath("//button[@text='Login']")).click(); // click on login Button
////        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(BuyerEmail); //Enter Email
////        driver.findElement(By.xpath("//button[@class='w3a-button w-full']")).click(); // submit
////        driver.switchTo().newWindow(WindowType.TAB); // open new tab
////        driver.get("https://yopmail.com/"); // open yopmail
////        driver.findElement(By.id("login")).sendKeys(BuyerEmail);
////        driver.findElement(By.id("refreshbut")).click();
////        Thread.sleep(2000);
////        driver.findElement(By.id("refresh")).click(); // click on the refresh button
////        driver.switchTo().frame("ifmail");
////        Thread.sleep(2000);
////        driver.findElement(By.xpath("//a[text()='Approve login request']")).click();
////        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
////        driver.switchTo().window(WinHandel.get(0));
////    }
////
//////    @Test(priority = 3)
//////    public void createNFT() throws InterruptedException {
//////        driver.get("https://uat.fan-verse.io/create-nft");
//////        driver.findElement(By.xpath("//input[@placeholder='Item Name']")).sendKeys("NFT 1 Bydfgf " + generatedString); // NFT Name
//////        driver.findElement(By.id("basic_description")).sendKeys("This is the description for NFT of This is the description for NFT of This is the description for NFT of This is the description for NFT of " + generatedString);
//////        driver.findElement(By.xpath("//span[@title='Select collection']")).click(); // open collections
//////        driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[2]")).click(); // Select the collection
//////        driver.findElement(By.id("basic_supply")).sendKeys("10"); // Enter Supply
//////        driver.findElement(By.id("basic_upload")).sendKeys("D:\\FanSec\\NFT Image.jpg"); // Upload NFT Image
//////        Thread.sleep(1000);
//////        driver.findElement(By.xpath("//button[@type='submit']")).click(); // Submit the NFT
//////
//////
//////
//////    }
//////        @Test(priority = 3)
//////         public void createNFT() throws InterruptedException {
//////            driver.get("https://uat.fan-verse.io/nft/f56d3a47-7d93-4573-91b4-be5a77bb4349");
//////        //      WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
////////             invisibilityOfElementLocated condition
//////           //  w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@aria-label='loading']")));
//////            WebElement el = driver.findElement(By.xpath("//span[@aria-label='loading']"));
//////            Thread.sleep(2000);
//////            while (el.isDisplayed())
////            {
////            }
////           WebElement si = driver.findElement(By.xpath("//button[@text='Sign your NFT']"));//Sign Your NFT
////            System.out.println(si.isEnabled());
////            si.click();
////            String winHandleBefore = driver.getWindowHandle();
////
////// Perform the click operation that opens new window
////
////// Switch to new window opened
////            for(String winHandle : driver.getWindowHandles()){
////                driver.switchTo().window(winHandle);
////            }
////            driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
////            driver.findElement(By.xpath("(//span[@class='v-btn__content'])[3]")).click();
//////            WebElement el = driver.findElement(By.xpath("//span[@aria-label='loading']"));
//////            WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
//////           w.until(.invisibility_of_element_located((By.xpath("//span[@aria-label='loading']")));
////
//////            WebElement el = driver.findElement(By.xpath("//span[@aria-label='loading']"));
//////            do {
//////                    driver.navigate().to("https://www.google.com/");
//////            }
//////            while (el.isDisplayed());
////
////
////          //  WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
////            // invisibilityOfElementLocated condition
////            // w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@aria-label='loading']")));
//////            WebElement ele = driver.findElement(By.xpath("//span[@aria-label='loading']"));
//////            while (ele.isDisplayed())
//////            {
//////                System.out.println( "In While");
//////                if (ele.isDisplayed()==false)
//////                {
//////                    System.out.println("In if");
//////                    driver.navigate().to("https://www.google.com/");
//////                }
//////            }
////
////
////           // driver.navigate().to("https://www.google.com/");
//////            Thread.sleep(17000);
//////            driver.findElement(By.xpath("//button[@text='Sign your NFT']")).click();    //Sign Your NFT
//////            Thread.sleep(5000);
//////            driver.findElement(By.xpath("(//span[@class='v-btn__content'])[3]")).click();
////        }
//
//
////    @Test(priority = 3)
////    public void profile() throws InterruptedException {
////        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
////        //   driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-primary'])[2]")).click();
////        //   driver.findElement(By.id("basic_name")).click();
////        //   Thread.sleep(1000);
////        driver.findElement(By.tagName("body")).click();
////        driver.findElement(By.id("basic_bio")).sendKeys("This is the Bio of " + generatedString); // Enter the Bio
////        driver.findElement(By.id("basic_mintWebsite")).sendKeys("www." + generatedString + ".com"); // Enter Website
////        driver.findElement(By.id("basic_username")).sendKeys("user" + generatedString); // Enter Username
////        driver.findElement(By.id("profile")).sendKeys("D:\\FanSec\\50kb.jpg"); // upload profile Image
////        driver.findElement(By.id("bannerimg")).sendKeys("D:\\FanSec\\1mb.jpg"); // upload banner image
////        Thread.sleep(3000);
////        WebElement name = driver.findElement(By.id("basic_name"));
////        name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); // clear the Name field
////        driver.findElement(By.id("basic_name")).sendKeys("testsim" + generatedString); // Enter name
////        driver.findElement(By.xpath("//button[@type='submit']")).click(); // Submit the profile form
////    }
////
////        @Test (priority = 4)
////        public void applyCreater() throws InterruptedException {
////            //driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
////            Thread.sleep(10000);
////            driver.navigate().to("https://uat.fan-verse.io/home");
////            //driver.findElement(By.xpath("//a[@class='fan-logo']")).click(); // Go to homepage
////            driver.findElement(By.linkText("Apply to be a Creator")).click(); // Click on apply to a creater
////            Thread.sleep(2000);
////            driver.findElement(By.xpath("(//button[@class='ant-btn ant-btn-primary'])[3]")).click(); // CLick on OK button
////            //Thread.sleep(2000);
////            driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click(); // submit the KYC
////            Thread.sleep(1000);
////         //   driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click(); // submit the KYC
////
////        }
////
////        @Test (priority = 5)
////        public void approveRequest() throws InterruptedException {
////            driver.switchTo().newWindow(WindowType.TAB);
////            driver.get("https://uat-admin.fan-verse.io/");
////            driver.findElement(By.id("basic_email")).sendKeys("admin@gmail.com"); // Enter Email
////            driver.findElement(By.id("basic_password")).sendKeys("FanVerse@123"); // Enter Password
////            driver.findElement(By.xpath("//button[@text='Log in']")).click();  //  Log in
////            Thread.sleep(3000);
////            driver.findElement(By.xpath("//a[@href='/users_creators']")).click(); // Click on users and creaters
////            driver.manage().timeouts().implicitlyWait(10000 ,TimeUnit.SECONDS);
////            driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-success']")).click(); // Click on 1st Entry
////            Thread.sleep(2000);
////            driver.findElement(By.xpath("//input[@value='2']")).click(); // Click on creater
////            driver.findElement(By.xpath("//button[@type='submit']")).click(); // Submit as a creater
////            ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
////            driver.switchTo().window(WinHandel.get(0));
////            //Thread.sleep(5000);
////        }
//
//
//    }
}