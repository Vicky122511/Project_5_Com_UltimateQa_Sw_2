package browsefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseText
{
    public static WebDriver driver;

    public void openBrowser(String baseurl)
    {
        //launch the Chrome Browser
        driver = new ChromeDriver();

        //Open The URL into Browser
        driver.get(baseurl);

        //Open The URL into Maximise Window
        driver.manage().window().maximize();

        //We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser()
    {
        driver.quit();
    }
}
