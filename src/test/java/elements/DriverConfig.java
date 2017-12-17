package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertyLoader;

import java.io.File;

/**
 * Created by Family on 09-Aug-17.
 */
public class DriverConfig {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public WebDriver setNewDriver(){
        final File file = new File(PropertyLoader.loadProperty("path.webDriver"));
        System.setProperty(PropertyLoader.loadProperty("webDriver"), file.getAbsolutePath());
        driver = new ChromeDriver();

        return driver;
    }


    public WebDriver getDriver(){
        if (driver == null){
            driver = new DriverConfig().setNewDriver();
        }
        return driver;
    }

    public WebDriverWait getWait(){
        if(wait == null){
            wait = new WebDriverWait(driver, 5, 1000);
        }
        return wait;
    }
}
