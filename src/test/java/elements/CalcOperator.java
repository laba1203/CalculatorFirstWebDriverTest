package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Family on 05-Aug-17.
 */
public class CalcOperator {

    By operatorPath = By.xpath("//select[@ng-model='operator']");

    private WebDriver driver = new DriverConfig().getDriver();

    Select operatorField = new Select(driver.findElement(operatorPath));


    //Possible operators

    public void plus(){
        operatorField.selectByValue("ADDITION");
    }

    public void minus(){
        operatorField.selectByValue("SUBTRACTION");
    }

    public void multiply(){
        operatorField.selectByValue("MULTIPLICATION");
    }

    public void divide(){
        operatorField.selectByValue("DIVISION");
    }

    public void modulo(){
        operatorField.selectByValue("MODULO");
    }


}
