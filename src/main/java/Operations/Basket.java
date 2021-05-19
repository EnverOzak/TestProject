package Operations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Basket{

    protected final WebDriver driver;

    public Basket(WebDriver driver)
    {
        this.driver = driver;
    }

    public void Check_Price(String Product_Price){
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='total-price-box']/div[@class='total-price']/strong"));
        WebElement Basket_Price = products.get(products.size()-1);
        Assert.assertEquals(Product_Price, Basket_Price.getText());
    }

    public void Increase_Amount(){
        List<WebElement> selectAmountControls = driver.findElements(By.xpath("//select[@class='amount']"));
        WebElement selectControl = selectAmountControls.get(selectAmountControls.size()-1);
        Select DdAmount = new Select(selectControl);
        DdAmount.selectByValue("2");
        Assert.assertEquals("2",DdAmount.getFirstSelectedOption().getText());
    }

    public void Remove_Product(){
        WebElement DeleteBtn = driver.findElement(By.xpath("//a[@title='Sil']"));
        DeleteBtn.click();
    }

    public void Check_Amount(){
        List<WebElement> Container = driver.findElements(By.xpath("//*[@id=\"seller-group-12343047\"]"));
        Assert.assertEquals(0, Container.size());
    }
}
