package Operations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class HomePage {

    protected final WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void Check_Home(){
        Assert.assertTrue("Home Page is Checked", driver.getTitle().contains("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi"));
    }

    public void ClickUserBtn(){
        WebElement C_UserBtn = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[1]/div"));
        C_UserBtn.click();
    }

    public void ClickLoginBtn(){
        WebElement C_LoginBtn = driver.findElement(By.xpath("//a[@data-cy='header-login-button']"));
        C_LoginBtn.click();
    }

    public void Check_Logged(){
        WebElement user_panel = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]"));
        Assert.assertTrue(user_panel.isDisplayed());
    }

    public void Search(){
        WebElement Searchbar = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        WebElement SearchBtn = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button"));

        Searchbar.clear();
        Searchbar.sendKeys("bilgisayar");
        SearchBtn.click();
    }
}