import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

@BeforeMethod
// а почему именно метод а не тест?
public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
//    ChromeOptions options = new ChromeOptions();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//    options.addArguments("--start-maximized");
//    driver = new ChromeDriver(options);

}

@AfterMethod(alwaysRun = true)
public void tearDown(){
    driver.quit();
}}