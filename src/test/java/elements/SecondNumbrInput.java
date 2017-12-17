package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Family on 05-Aug-17.
 */
public class SecondNumbrInput {
    By secondFieldLocator = By.xpath("//input[@ng-model='second']");

    private WebDriver driver = new DriverConfig().getDriver();

    WebElement secondField = driver.findElement(secondFieldLocator);
}

