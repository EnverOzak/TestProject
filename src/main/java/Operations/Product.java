package Operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Product{

    protected final WebDriver driver;

    public Product(WebDriver driver)
    {
        this.driver = driver;
    }

    public void Add_to_Basket(){
        WebElement A_BasketBtn = driver.findElement(By.id("add-to-basket"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView()", A_BasketBtn);
        A_BasketBtn.click();
    }

    public void Open_Basket(){
        WebElement BasketBtn = driver.findElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a/div[1]/div"));
        BasketBtn.click();
    }

    public String Price(){
        WebElement price = driver.findElement(By.id("sp-price-highPrice"));
        return price.getText();
    }
}
