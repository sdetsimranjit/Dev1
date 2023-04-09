package Fanverse;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestFan {
    WebDriver driver;
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();
    String generatedString = random.ints(leftLimit, rightLimit + 1)
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

    String createrName = "Creater"+generatedString;
    String collectionName = "Coll"+generatedString;
    String nftName = "NFT 1 "+generatedString;
    String nftPrice = "0.001";
    String username = "User" + generatedString;
    String BuyerEmail = "Simtest@yopmail.com";
    //String endDate

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
        System.out.println("String is: - "+generatedString);
        driver.findElement(By.xpath("//button[@text='Login']")).click(); // click on login Button
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(generatedString + "@yopmail.com"); //Enter Email
        driver.findElement(By.xpath("//button[@class='w3a-button w-full']")).click(); // submit
        driver.switchTo().newWindow(WindowType.TAB); // open new tab
        driver.get("https://yopmail.com/"); // open yopmail
        driver.findElement(By.id("login")).sendKeys(generatedString);
        driver.findElement(By.id("refreshbut")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("refresh")).click(); // click on the refresh button
        driver.switchTo().frame("ifmail");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Approve login request']")).click();
        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WinHandel.get(0));
    }

    @Test(priority = 3)
    public void profile() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
        driver.findElement(By.tagName("body")).click();
        driver.findElement(By.id("basic_bio")).sendKeys("This is the Bio of " + generatedString); // Enter the Bio
        driver.findElement(By.id("basic_mintWebsite")).sendKeys("www." + generatedString + ".com"); // Enter Website
        driver.findElement(By.id("basic_username")).sendKeys(username); // Enter Username
        driver.findElement(By.id("profile")).sendKeys("D:\\FanSec\\50kb.jpg"); // upload profile Image
        driver.findElement(By.id("bannerimg")).sendKeys("D:\\FanSec\\1mb.jpg"); // upload banner image
        Thread.sleep(3000);
        WebElement name = driver.findElement(By.id("basic_name"));
        name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE)); // clear the Name field
        driver.findElement(By.id("basic_name")).sendKeys(createrName); // Enter name
        driver.findElement(By.xpath("//button[@type='submit']")).click(); // Submit the profile form
        System.out.println("Creater Name is: - " + createrName);
    }

        @Test (priority = 4)
        public void approveRequest() throws InterruptedException {
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://uat-admin.fan-verse.io/");
            driver.findElement(By.id("basic_email")).sendKeys("admin@gmail.com"); // Enter Email
            driver.findElement(By.id("basic_password")).sendKeys("FanVerse@123"); // Enter Password
            driver.findElement(By.xpath("//button[@text='Log in']")).click();  //  Log in
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[@href='/users_creators']")).click(); // Click on users and creaters
            driver.manage().timeouts().implicitlyWait(10000 ,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-success']")).click(); // Click on 1st Entry
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='2']")).click(); // Click on creater
            driver.findElement(By.xpath("//button[@type='submit']")).click(); // Submit as a creater
            ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(WinHandel.get(0));
            Thread.sleep(2000);
        }

    @Test(priority = 5)
    public void createCollection () throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        WebElement loader = driver.findElement(By.xpath("//span[@aria-label='loading']"));
        while (loader.isDisplayed()) {}
        driver.navigate().to("https://uat.fan-verse.io/create-collection");
        driver.findElement(By.xpath("//input[@placeholder='Collection Name']")).sendKeys(collectionName); // Enter collection name
        driver.findElement(By.id("basic_description")).sendKeys("This is the description of This is the description of " + generatedString); // Enter description
        driver.findElement(By.xpath("//span[@title='Select Category']")).click();
        driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[2]")).click(); //Select category
        driver.findElement(By.id("basic_royalty")).sendKeys("1"); // Enter Royality
        driver.findElement(By.id("img")).sendKeys("D:\\FanSec\\Coll logo.webp.jpg"); // Upload logo image
        driver.findElement(By.id("featureimg")).sendKeys("D:\\FanSec\\coll feature.jpg"); // Upload feature image
        driver.findElement(By.id("bannerimg")).sendKeys("D:\\FanSec\\Coll banner.jpg"); // Upload banner Image
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='new__creater__form__submit__data']")).click(); //Submit the collection
        System.out.println("Collection Name is: - "+ collectionName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='textSection']"));
    }

    @Test(priority = 6)
    public void createNFT() throws InterruptedException {
        driver.get("https://uat.fan-verse.io/create-nft");
        driver.findElement(By.xpath("//input[@placeholder='Item Name']")).sendKeys(nftName); // NFT Name
        driver.findElement(By.id("basic_description")).sendKeys("This is the description for NFT of  " + generatedString);
        driver.findElement(By.xpath("//span[@title='Select collection']")).click(); // open collections
        driver.findElement(By.xpath("(//div[@class='ant-select-item-option-content'])[2]")).click(); // Select the collection
        driver.findElement(By.id("basic_supply")).sendKeys("10"); // Enter Supply
        driver.findElement(By.id("basic_upload")).sendKeys("D:\\FanSec\\NFT Image.jpg"); // Upload NFT Image
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click(); // Submit the NFT
        System.out.println("NFT name is: - "+ nftName);

    }
    @Test ( priority = 7)
    public void signNFT() throws InterruptedException {
        WebElement el = driver.findElement(By.xpath("//span[@aria-label='loading']"));
        Thread.sleep(2000);
        while (el.isDisplayed()) {}
        driver.findElement(By.xpath("//button[@text='Sign your NFT']")).click();//Sign Your NFT
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);}
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[@class='v-btn__content'])[3]")).click();
        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WinHandel.get(0));
    }
    @Test(priority = 8)
    public void listNFT () throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@text='List Item']")).click();
        driver.findElement(By.id("basic_price")).sendKeys(nftPrice ); // Enter Sale Price
        driver.findElement(By.xpath("//input[@placeholder='End date']")).sendKeys("2023-04-30");
        driver.findElement(By.xpath("//input[@placeholder='End date']")).click(); // Open the end day Calendar
        driver.findElement(By.xpath("//td[@title='2023-04-29']")).click(); // Select the End date
        driver.findElement(By.xpath("//button[@text='List Item']")).click(); // List the NFT ( Click on submit )
        Thread.sleep(2000);
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){driver.switchTo().window(winHandle);}
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//span[@class='v-btn__content'])[3]")).click();
        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WinHandel.get(0));
        System.out.println(nftName + " from collection " + collectionName + " is ready to buy at price " + nftPrice);
        Thread.sleep(2000);
        driver.quit();
    }

//------------------------------------------- Buyer Side  -----------------------------------------------------------//

    @Test(priority = 9)
    public void LoginBuyer() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://uat.fan-verse.io/home");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@text='Login']")).click(); // click on login Button
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(BuyerEmail); //Enter Email
        driver.findElement(By.xpath("//button[@class='w3a-button w-full']")).click(); // submit
        driver.switchTo().newWindow(WindowType.TAB); // open new tab
        driver.get("https://yopmail.com/"); // open yopmail
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys(BuyerEmail);
        driver.findElement(By.id("refreshbut")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("refresh")).click(); // click on the refresh button
        driver.switchTo().frame("ifmail");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Approve login request']")).click();
        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WinHandel.get(0));
        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='textSection']"));
    }

    @Test(priority = 10)
    public void BuyNFT() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(nftName); // Search the NFT
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[@class='cardCollectionStyle__details__creatorName']")).click(); // Click on NFT
        driver.manage().timeouts().implicitlyWait(40000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@text='Buy Now']")).click(); // Click on Buy Now
        driver.findElement(By.xpath("//button[@text='Buy']")).click(); // Click on Buy from listings
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click(); // Click on complete purchase
        Thread.sleep(2000);
        // Click on the button that opens the new window

// Get the handle of the current window
        Thread.sleep(2000);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click(); // Click on Confirm Button
        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WinHandel.get(0));
        System.out.print(driver.findElement(By.xpath("//div[@class='textSection']")).getText());
        driver.navigate().to("https://uat.fan-verse.io/mynft");

    }
}