package testWithElements;

import elements.CalculatorPage;
import elements.DriverConfig;
import elements.History;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Family on 05-Aug-17.
 */
public class CalculatorTesting {
    private WebDriver driver = new DriverConfig().getDriver();
    private WebDriverWait wait;
    private CalculatorPage page;
    private History history;



    @BeforeClass
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        page = new CalculatorPage();
        page.openCalcPage();

    }



    @Test
    public void test1(){
        String result = page.operation("1", "ADDITION", "20", "21");
        Assert.assertEquals(result, "21");

    }

    @Test
    public void test2(){
        page.operation("17", "MODULO", "3", "2");

    }

    @Test
    public void test3(){
        page.operation("100", "MULTIPLICATION", "3", "300");

    }

    @Test
    public void test4(){
        page.operation("100", "SUBTRACTION", "3", "97");
    }





}
