package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Family on 05-Aug-17.
 */
public class FirstNumbrInput {

    By firstFieldLocator = By.xpath("//input[@ng-model='first']");

    private WebDriver driver = new DriverConfig().getDriver();

    WebElement firstField = driver.findElement(firstFieldLocator);


}
