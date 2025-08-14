package pageobject;

import AbsractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponents {

    public OrderPage(WebDriver driver) {
        super(driver);
        //constracter
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tr td:nth-child(3)")
    private List<WebElement> productsNames;

    public Boolean VerifyOrderDisplay(String productName) {
        boolean match = productsNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        return match;
    }

}
