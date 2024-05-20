package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By logout = By.id("p_lt_ctl03_wSOB_btnSignOutLink");
    By home = By.id("p_lt_ctl02_wCU2_lblLabel");

    public HomePage(WebDriver dr){
        this.driver=dr;
    }
    public String pageVerify(){
        return driver.findElement(home).getText();
    }
    public void logout(){
        driver.findElement(logout).click();
    }
}
