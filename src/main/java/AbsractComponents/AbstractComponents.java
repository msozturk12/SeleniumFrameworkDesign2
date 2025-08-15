package AbsractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.CartPage;
import pageobject.OrderPage;


import java.time.Duration;

public class AbstractComponents {
    public WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;

    }
    //driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(xpath = "/html/body/app-root/app-myorders/app-sidebar/nav/ul/li[3]/button")
    WebElement orderHeader;

    // /html/body/app-root/app-myorders/app-sidebar/nav/ul/li[3]/button
    public AbstractComponents() {
    }

    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public CartPage gotoCartPage() {
        CartPage cartPage = new CartPage(driver);
        return cartPage;

    }
    public OrderPage gotoOrderPage() {
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;

    }

    public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
        Thread.sleep(3000);
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.invisibilityOf(ele));
        System.out.println("Test für Github übung");

    }

}
