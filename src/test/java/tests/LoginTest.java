package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest1 {
    @Test
    public void loginWithValidData(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertTrue(inventoryPage.titleIsVisible());
    }

    @Test
    public void userNameShouldBeRequired(){
        loginPage.open();
        loginPage.login("","secret_sauce");
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required","текст сообщения неверный");

    }
    @Test
    public void passwordShouldBeRequired(){
        loginPage.open();
        loginPage.login("standart_user","");
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required","текст сообщения неверный");
    }
    @Test
    public void userWithInvalidData(){
        loginPage.open();
        loginPage.login("wiwiwiw","wiwiwiwi");
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service","текст сообщения неверный");
    }

    @Test
    public void lockedOutUserAutorization(){
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.","текст сообщения неверный");
    }
    @Test
    public void waiter(){
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");
        driver.findElement(By.id("react-burger-menu-bnt")).click();
        driver.findElement(By.id("about-sidebar-link")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about-sidebar-link")));



        Actions actions = new Actions(driver);
        actions.click();

    }


}
