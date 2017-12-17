package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class CalculatorPage {

    private FirstNumbrInput firstNumbrInput;
    private SecondNumbrInput secondNumbrInput;
    private CalcOperator calcOperator;
    private GoButton button;
    private Result result;
    private History historyTable;
    private DriverConfig driverConfiguration = new DriverConfig();

    private WebDriver driver = driverConfiguration.getDriver();
    private WebDriverWait wait = driverConfiguration.getWait();

    public void openCalcPage(){
        driver.navigate().to("http://juliemr.github.io/protractor-demo/");

    }



    public String operation(String value1, String operator , String value2, String expectedValue){
        firstNumbrInput = new FirstNumbrInput();
        secondNumbrInput = new SecondNumbrInput();
        calcOperator = new CalcOperator();
        button = new GoButton();
        result = new Result();
        String resultInHistory = null;

        firstNumbrInput.firstField.sendKeys(value1);
        secondNumbrInput.secondField.sendKeys(value2);
        calcOperator.operatorField.selectByValue(operator);
        button.goButton.click();

        try{
            wait.until(ExpectedConditions.textToBePresentInElementLocated(result.resultLocator, expectedValue));
            resultInHistory = new History().getFirstRow().getResult();
        }
        catch (org.openqa.selenium.TimeoutException e){
//            Assert.assertTrue(false);
            System.out.println("Incorrect value in Result field.  Expected result: " + expectedValue +". Actual value: " + result.getResult());
        }
        resultInHistory = new History().getFirstRow().getResult();
        return  resultInHistory;

    }









}
