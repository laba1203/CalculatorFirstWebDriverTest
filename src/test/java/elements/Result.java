package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Family on 05-Aug-17.
 */
public class Result {
    By resultLocator = By.xpath("//h2[@class = 'ng-binding']");
    private WebDriver driver = new DriverConfig().getDriver();
    WebElement resultField = driver.findElement(resultLocator);

    public String getResult(){
        return resultField.getText();
    }
}
