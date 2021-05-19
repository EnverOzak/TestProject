package Operations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;

public class After_Search{

    protected final WebDriver driver;

    public After_Search(WebDriver driver)
    {
        this.driver = driver;
    }

    public void Check_Search(){
        Assert.assertTrue(driver.getTitle().contains("Bilgisayar - GittiGidiyor"));
    }

    public void Open_Page2(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Page2Btn = driver.findElement(By.xpath("//a[@href='/arama/?k=bilgisayar&sf=2']"));
        js.executeScript("arguments[0].scrollIntoView();", Page2Btn);
        Page2Btn.click();
    }

    public void Check_Page2(){
        Assert.assertTrue(driver.getTitle().contains("Bilgisayar - GittiGidiyor - 2/100"));
    }

    public void Choose_Product(){
        Random rand = new Random();
        int rand_num = rand.nextInt(48-1) + 1;
        WebElement Product = driver.findElement(By.xpath("//li[@product-index='" + rand_num + "']"));
        Product.click();
    }
}