package Operations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Login{

    protected final WebDriver driver;

    public Login(WebDriver driver)
    {
        this.driver = driver;
    }

    public void Check_Login(){
        Assert.assertTrue(driver.getTitle().contains("Üye Girişi - GittiGidiyor"));
    }

    public void Login(){
        WebElement email_input = driver.findElement(By.id("L-UserNameField"));
        WebElement password_input = driver.findElement(By.id("L-PasswordField"));
        WebElement LoginBtn = driver.findElement(By.id("gg-login-enter"));
        email_input.clear();
        password_input.clear();
        email_input.sendKeys("");
        password_input.sendKeys("");
        LoginBtn.click();
    }
}