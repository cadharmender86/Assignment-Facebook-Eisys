package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BrowserSelection {
    public WebDriver selectBrowser() throws IOException {
        FileInputStream fis = null;
        File configfile = new File(".\\Configuration\\config.properties");
        fis = new FileInputStream(configfile);
        Properties prop = new Properties();
        prop.load(fis);
        WebDriver driver = null;

        String browser = prop.getProperty("browser");

        while (browser == null) {
            System.out.println("Browser is not specified in config file. Terminating process!!!");
            System.exit(0);
        }

        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

            System.out.println("Browser selected for testing is: Mozilla Firefox");

        } else
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();

                System.out.println("Browser selected for testing is: Google Chrome");
            } else
                if (browser.equalsIgnoreCase("ie")) {
                    driver = new InternetExplorerDriver();

                    System.out.println("Browser selected for testing is: Internet Explorer");
                } else
                    System.out.println("Selected browser value should be either firefox or chrome or ie --> Update in Configuration file is required");
                    System.exit(0);

                }
                return driver;
            }
        }

    }
}
