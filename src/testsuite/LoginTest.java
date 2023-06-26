package testsuite;

import browsefactory.BaseText;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseText
{
    String baseurl = "https://courses.ultimateqa.com/";
    String expectedText,actualText;

    @Before
    public void setUp()
    {
        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        //Verify the text ‘Welcome Back!’
        expectedText="Welcome Back!";
        actualText=driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Both Text Are Not Equal",expectedText,actualText);

    }

    @Test
    public void verifyTheErrorMessage()
    {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        // Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("abc.shah@gmail.com");

        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("ABCSHAH@");

        //Click on Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();

        // Verify the error message ‘Invalid email
        //or password.'
        expectedText="Invalid email or password.";
        actualText=driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Message Matched",expectedText,actualText);

    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
