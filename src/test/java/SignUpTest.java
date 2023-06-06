import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class SignUpTest {
    //базовый тест сделать+ повторяющиеся локаторы вынести в поля

    @Test
    public void zipCodeShouldAccept5Digits(){
        //1. Перейти на https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        //2. В поле Зип-код ввести - 12345
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        //3. Нажать кнопку continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        //4. Убедиться что мы перешли на старницу ввода данных пользователя
        WebElement registerButton = driver.findElement((By.cssSelector("[value=Register]")));
        boolean isDisplayed = registerButton.isDisplayed();
        Assert.assertTrue(isDisplayed, "Нужная страница не открылась");
        //5. Закрыть браузер
        driver.quit();
    }



@Test
public void zipCodeShouldNotAccept4Digits() {

    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.sharelane.com/cgi-bin/register.py");

    WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
    zipCodeInput.sendKeys("1234");

    WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
    continueButton.click();

    WebElement errorMessage = driver.findElement((By.cssSelector("[class='error_message']")));
    boolean isDisplayed = errorMessage.isDisplayed();
    //проверить сообщение ошибки + сравнить сообщения()
    Assert.assertTrue(isDisplayed, "Текст errormessage получен");

//    driver.quit();
//}
}}

