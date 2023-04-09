package AutoPack1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class NewMetaCRX {
    WebDriver driver;
    String Password = "Admin@123";

    @Test(priority = 0)
    void launchBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("C:\\Users\\user\\Downloads\\MetaMask.crx"));
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        ArrayList<String> WinHandel = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(WinHandel.get(0));
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    void createNewWallet() {
        driver.findElement(By.xpath("//button[@class='button btn--rounded btn-primary']")).click(); //click on create a new wallet button
        driver.findElement(By.xpath("//button[@data-testid='metametrics-i-agree']")).click(); //Click on I agree
    }

    @Test(priority = 2)
    void createPassword() throws InterruptedException {

        driver.findElement(By.xpath("//input[@data-testid='create-password-new']")).sendKeys(Password); //Enter Password
        driver.findElement(By.xpath("//input[@data-testid='create-password-confirm']")).sendKeys(Password); //Confirm Password
        driver.findElement(By.xpath("//input[@data-testid='create-password-terms']")).click(); // click on terms
        driver.findElement(By.xpath("//button[@data-testid='create-password-wallet']")).click(); // Click on Create a new wallet button
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    void secureMyWallet() throws IOException, UnsupportedFlavorException, InterruptedException {
        driver.findElement(By.xpath("//button[@data-testid='secure-wallet-recommended']")).click(); // Click on secure my wallet
        driver.findElement(By.xpath("//button[@data-testid='recovery-phrase-reveal']")).click(); //Reveal the recovery phrase
       String [] mn = new String[12];
        for(int i=0;i<=11;i++)
        {
            mn[i] = driver.findElement(By.xpath("//div[@data-testid='recovery-phrase-chip-"+i+"']")).getText();
            System.out.println(mn[i]);
        }

//        driver.findElement(By.xpath("//a[@class='button btn-link recovery-phrase__footer__copy-and-hide__button recovery-phrase__footer__copy-and-hide__button__copy-to-clipboard']")).click(); //copy the recover phrases
//        String cs = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor); // Save the copied value
//        System.out.println("Copied Text is:: " + cs);
          driver.findElement(By.xpath("//button[@data-testid='recovery-phrase-next']")).click(); //click on next button
//        Thread.sleep(2000);
//        String[] mnemonics = cs.split(" ");
//        System.out.println(mn[2]);
//        System.out.println(mn[3]);
//        System.out.println(mn[7]);
//        driver.findElement(By.xpath("//input[@data-testid='recovery-phrase-input-2']")).sendKeys(mnemonics[2]); // Enter the 3rd Mnemonic value
//        driver.findElement(By.xpath("//input[@data-testid='recovery-phrase-input-3']")).sendKeys(mnemonics[3]); // Enter the 4th Mnemonic value
//        driver.findElement(By.xpath("//input[@data-testid='recovery-phrase-input-7']")).sendKeys(mnemonics[7]); // Enter the 8th Mnemonic


        for ( int j=1;j<=8;j++)
        {
            if(j==2 || j==3 || j==7)
            {
             //   driver.findElement(By.xpath("//input[@data-testid='recovery-phrase-input-"+ j +"]")).sendKeys(mn[j]);
              driver.findElement(By.xpath("//input[@data-testid='recovery-phrase-input-"+j+"']")).sendKeys(mn[j]);
            }

        }
//        driver.findElement(By.tagName("body")).click();
        Thread.sleep(2000);
     //   driver.findElement(By.xpath("//button[@data-testid='recovery-phrase-confirm']")).click(); // click on confirm button
    }
}

