package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by MLaba on 14-Aug-17.
 */
public class TableRow {
    By resultLocator = By.xpath("//tr[@ng-repeat = 'result in memory'][1]/td[3]");
    By timeLocator = By.xpath("//tr[@ng-repeat = 'result in memory'][1]/td[1]");
    By firstValueExpressionLocator = By.xpath("//tr[@ng-repeat = 'result in memory'][1]/td[2]/span[1]");
    By operatorValueExpressionLocator = By.xpath("//tr[@ng-repeat = 'result in memory'][1]/td[2]/span[2]");
    By secondValueExpressionLocator = By.xpath("//tr[@ng-repeat = 'result in memory'][1]/td[2]/span[3]");


    private WebDriver driver = new DriverConfig().getDriver();

    public WebElement result = driver.findElement(resultLocator);
    public WebElement timeHistory = driver.findElement(timeLocator);
    public WebElement firstValueInExpression = driver.findElement(firstValueExpressionLocator);
    public WebElement operatorValueInExpression = driver.findElement(operatorValueExpressionLocator);
    public WebElement secondValueInExpression = driver.findElement(secondValueExpressionLocator);



    public String getExpression(){

        String expression = firstValueInExpression + " " + operatorValueInExpression + " " + secondValueInExpression;
        return  expression;

    }

    public String getResult(){

        return result.getText();
    }


}
