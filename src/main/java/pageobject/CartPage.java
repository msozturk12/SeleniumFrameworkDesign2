package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbsractComponents.AbstractComponents;

import java.util.List;

public class CartPage extends AbstractComponents {

    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(xpath = "(//h5)[1]")
     List<WebElement> cartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        //constracter
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
    //Page Factory


    public Boolean VerifyProductDisplay(String productName) {
        boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckoutPage goToCheckout() {
        checkoutEle.click();
        return new CheckoutPage();

    }

}
