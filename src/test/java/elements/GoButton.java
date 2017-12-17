package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Family on 05-Aug-17.
 */
public class GoButton {
    By goButtonLocator = By.id("gobutton");

    private WebDriver driver = new DriverConfig().getDriver();
    WebElement goButton = driver.findElement(goButtonLocator);
}
