package testWithElements;

import elements.CalculatorPage;
import elements.DriverConfig;
import elements.History;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.TestDataConverter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Family on 26-Aug-17.
 */
public class DataDrivenTesting {
    private WebDriver driver = new DriverConfig().getDriver();
    private WebDriverWait wait;
    private CalculatorPage page;
    private History history;
    private TestDataConverter data = new TestDataConverter("testData.csv");

    public DataDrivenTesting() throws IOException {
    }


    @BeforeClass
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page = new CalculatorPage();
        page.openCalcPage();

    }



    @DataProvider
    public Object[][] testData(){
        return data.getDataFromFile();
//        return new Object[][]{
////                data.getDataFromFile().toArray()
//                new Object[]{"1", "ADDITION", "20", "21"},
//                new Object[]{"17", "MODULO", "3", "2"},
//                new Object[]{"100", "MULTIPLICATION", "3", "300"},
//                new Object[]{"100", "SUBTRACTION", "3", "97"},
//
//        };
    }


    @Test(dataProvider = "testData")
    public void test(String value1, String operator, String value2, String expectedValue){
        page.operation(value1, operator, value2, expectedValue);
        history = new History();
        Assert.assertEquals(history.getFirstRow().getResult(), expectedValue);
    }
}
