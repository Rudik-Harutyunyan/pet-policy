package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseSelenium {


   public WebDriver driver;


    private String baseUrl = "https://stage.ourpetpolicy.com/";

    public String getBaseUrl(){
        return baseUrl;
    }

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\start\\Desktop\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }



}
