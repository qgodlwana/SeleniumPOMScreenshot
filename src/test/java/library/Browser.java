package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
    static WebDriver driver;
    public static WebDriver StartBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("firefox")) {
            // Set the path for geckodriver.exe
            System.setProperty("webDriver.firefox.marionette", "");
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("Chrome"))
        {
            // Set the path for chromedriver.exe
            System.setProperty("webDriver.chrome.driver","C:/Java//drivers//chrome//chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("IE"))
        {
            // Set the path for IEDriver.exe
            System.setProperty("webDriver.ie.driver","");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
