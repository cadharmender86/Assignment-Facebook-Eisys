package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import utilities.ExcelApiTest;
import utilities.ExcelBaseSetup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    String xlFilePath = ".\\UserData.xlsx";
    String sheetName = "Data";
    ExcelApiTest eat = null;
    ExcelBaseSetup base;
    WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException, InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
//        String URL= baseHelper.getGobalValue("baseUrl");
        driver.get("https://www.facebook.com/");
        Thread.sleep(3000);
    }

        @DataProvider(name="userData")
        public Object[][] userFormData() throws Exception
        {
            Object[][] data = testData(xlFilePath, sheetName);
            return data;
        }

        public Object[][] testData(String xlFilePath, String sheetName) throws Exception
        {
            Object[][] excelData = null;
            eat = new ExcelApiTest(xlFilePath);
            //base = new ExcelBaseSetup();
            int rows = eat.getRowCount(sheetName);
            int columns = eat.getColumnCount(sheetName);

            excelData = new Object[rows-1][columns];

            for(int i=1; i<rows; i++)
            {
                for(int j=0; j<columns; j++)
                {
                    excelData[i-1][j] = eat.getCellData(sheetName, j, i);
                }

            }
            return excelData;
        }

        @AfterMethod
        public void tearDown(){
          //  driver.close();
           //pressing Logout Option
            // click on Account option
            driver.findElement(By.cssSelector("div[aria-label='Account']")).click();
            //click on log out
            driver.findElement(By.xpath("//span[normalize-space()='Log Out']")).click();
            driver.close();


        }


    }
