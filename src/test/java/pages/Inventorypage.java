package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventorypage extends BasePage {

    public static final By INVENTORY_TITLE =By.xpath("//span[@class = 'title' and text() = 'Products']");
    public Inventorypage(WebDriver driver) {
        super(driver);
    }
    public boolean titleIsVisible(){
        return driver.findElement(INVENTORY_TITLE).isDisplayed();
    }
}
