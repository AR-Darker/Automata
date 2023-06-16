package tests;

import pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest1 {

    WebDriver driver;
    LoginPage loginPage;

@BeforeMethod

public void setUp(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    loginPage = new LoginPage(driver);


}

@AfterMethod(alwaysRun = true)
public void tearDown() {
    driver.close();
    driver.quit();
}}