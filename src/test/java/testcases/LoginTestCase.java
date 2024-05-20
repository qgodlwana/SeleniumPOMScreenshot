package testcases;

import library.Browser;
import library.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginTestCase {

    WebDriver driver;
    LoginPage lp;
    HomePage hp;
    int i=0;
    //launch of the given browser.
    @BeforeTest
    public void browserLaunch(){
        driver = Browser.StartBrowser("Chrome","https://www.url.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));

        lp = new LoginPage(driver);
        hp = new HomePage(driver);
    }
    //login to site
    @Test(priority = 1)
    public void Login(){
        lp.loinToSite("gaurav.3n@gmail.com","Test@123");
    }

    //verify the home page
    @Test(priority = 2)
    public void verifyHomePage(){
        String HomeText = hp.pageVerify();
        Assert.assertEquals(HomeText, "Logged on as");
    }

    //logout the site
    @Test(priority = 3)
    public void Logout(){
        hp.logout();
    }

    //taking screenshot on test fail
    @AfterMethod
    public void screenshot(ITestResult result){
        i=i+1;
        String name = "ScreenShot";
        //String x = name+String.valueOf(i);
        String x = name+i;
        if(ITestResult.FAILURE == result.getStatus()){
            ScreenShot.captureScreenShot(driver, x);
        }
    }
    //close browser
    @AfterTest
    public void closeBrowser(){
        driver.close();
    }
}
