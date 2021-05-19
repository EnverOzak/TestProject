import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import Operations.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;


public class Main {
    protected WebDriver webDriver;
    FirefoxOptions options = new FirefoxOptions();
    Logger logger = LogManager.getLogger(Main.class);

    @Before
    public void PageOPen(){
        System.setProperty("webdriver.gecko.driver",".\\driver\\geckodriver.exe");
        webDriver = new FirefoxDriver(options);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void Operations(){

        webDriver.get("https://www.gittigidiyor.com/");

        HomePage homePage = new HomePage(webDriver);
        homePage.Check_Home();
        logger.info("Home Page Opened");
        homePage.ClickUserBtn();
        homePage.ClickLoginBtn();

        Login loginP = new Login(webDriver);
        loginP.Check_Login();
        logger.info("Login Page Opened");
        loginP.Login();

        homePage.Check_Logged();
        logger.info("Logged in");
        homePage.Search();

        After_Search after_searchP = new After_Search(webDriver);
        after_searchP.Check_Search();
        logger.info("Bilgisayar is Searched");
        after_searchP.Open_Page2();
        after_searchP.Check_Page2();
        logger.info("Page 2 Opened");
        after_searchP.Choose_Product();
        logger.info("Product Added to the Basket");

        Product productP = new Product(webDriver);
        productP.Add_to_Basket();
        String O_price = productP.Price();
        productP.Open_Basket();

        Basket basketP = new Basket(webDriver);
        basketP.Check_Price(O_price);
        logger.info("Prices are the Same");
        basketP.Increase_Amount();
        basketP.Remove_Product();
        basketP.Check_Amount();
        logger.info("There is no Prodouct in the Basket");
    }

    @After
    public void Exit() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }
}