import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TheInternet extends BaseTest{
//DropDown TEST
    @Test
    public void checkDropDown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List options = select.getOptions();

        assertEquals(options.size(),3);
        select.selectByIndex(1);
        assertEquals(select.getFirstSelectedOption().getText(),"Option 1");

        select.selectByIndex(2);
        assertEquals(select.getFirstSelectedOption().getText(),"Option 2");



        WebDriver driver = new ChromeDriver();

        




    }














}
