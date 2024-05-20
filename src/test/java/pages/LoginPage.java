package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    By UserId = By.xpath("//*[contains(@id,'Login1_UserName')]");
    By Password = By.xpath("//*[contains(@id,'Login1_Password')]");
    By Submit = By.xpath("//*[contains(@id,'Login1_LoginButton')]");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void loinToSite(String username, String password){
        this.enterUsername(username);
        this.enterPassword(password);
        this.clickSubmit();
    }

    public void clickSubmit() {
        driver.findElement(Submit).click();
    }

    public void enterPassword(String password) {
        driver.findElement(Password).sendKeys(password);
    }

    public void enterUsername(String username) {
        driver.findElement(UserId).sendKeys(username);
    }

}
