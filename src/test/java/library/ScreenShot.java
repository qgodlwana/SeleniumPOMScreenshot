package library;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
    public static void captureScreenShot(WebDriver driver, String ScreenShotName)
    {
        try{
            //capture screenshot
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);

            //define screenshot and timestamp
            String screenshotName = "ErrorScreenshot";
            String datetime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            //define the destination file path with timestamp
            File destinationFile = new File("C://Automation//Screenshot//"+ screenshotName+"_"+datetime+".jpg");

            //create the directory if it doesn't exist
            destinationFile.getParentFile().mkdir();

            //copy the screenshot to the destination
            FileUtils.copyFile(screenshot, destinationFile);
            System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
