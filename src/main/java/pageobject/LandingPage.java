package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbsractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        //constracter
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //WebElement userEmail = driver.findElement(By.xpath("//input[@id='userEmail']"));
    //Page Factory

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(css = "#userPassword")
    WebElement passwordElement;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;

    //ng-tns-c4-1 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error

    public ProductCatalogue loginApplication(String email,String password){
        userEmail.sendKeys(email);
        passwordElement.sendKeys(password);
        submit.click();
        ProductCatalogue productCatalogue=new ProductCatalogue(driver);
        return productCatalogue;
    }
public String getErrorMessage(){
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
}
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");

    }

}
