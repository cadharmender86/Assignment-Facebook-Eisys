package TestCases;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class fbTestCase extends TestBase {

      @Test(dataProvider = "userData")
    public void LogIn(String username,String password) throws InterruptedException {
          System.out.println(username +" ====== "+ password);
          driver.manage().window().maximize();
          // putting username
        driver.findElement(By.id("email")).sendKeys(username);
        // putting password
        driver.findElement(By.id("pass")).sendKeys(password);
        // press submit button
          driver.findElement(By.xpath("//button[@type='submit']")).click();
          //  =========================================================================
        //clicking on What's on your mind
          driver.findElement(By.xpath("//span[contains(text(), 'on your mind')]")).click();
        //click to change post sharing option
          driver.findElement(By.xpath("//div[contains(@aria-label,'Edit privacy')]")).click();
        //click on post shared only with me
        driver.findElement(By.xpath("//div[@aria-checked='true']")).click();
                //click on text box in order to post
          Thread.sleep(5000);
      WebElement postTest = driver.findElement(By.xpath("//div[@role='textbox'] [@tabindex='0']"));
      postTest.click();
       // writing post in tsxt box
      postTest.sendKeys("helloo this is 7th post");
      //click post button
      WebElement post = driver.findElement(By.xpath("//span[@dir='auto'] [normalize-space()='Post']"));
      post.click();
        Thread.sleep(10000);
        //=================================================================================================
          //Password change schenario
          //click on Account option
       driver.findElement(By.cssSelector("div[aria-label='Account']")).click();
       //Go to Setting & Privacy
       driver.findElement(By.xpath("//span[normalize-space()='Settings & Privacy']")).click();
       //Go to Settings
       driver.findElement(By.xpath("//a[@href='/settings']")).click();
       //Go to Security & Login
          System.out.println("Mine");
       driver.findElement(By.xpath("//span[normalize-space()='Security and Login']")).click();
        //Go to Change Password option
          System.out.println("Dharmu");
       driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/button[1]")).click();
          System.out.println("Swara");
       Thread.sleep(10000);
    }
}




