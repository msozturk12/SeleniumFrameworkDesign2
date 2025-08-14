package inarAcademy.stepDefinitions;

import inarAcademy.TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobject.*;

import java.io.IOException;
import java.util.List;

public class StepDefinitionsImpl extends BaseTest {
    public LandingPage landingPage;
    ProductCatalogue productCatalogue;
    ConfirmationPage confirmationPage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.+) and (.+)$")
    public void logged_in_username_and_password(String username, String password) {
        productCatalogue = landingPage.loginApplication(username, password);

    }

    @When("^I add (.+) to Cart$")
    public void i_add_product_to_cart(String productName) throws InterruptedException {
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
    }

    @When("^Checkout (.+) and submit the order$")
    public void check_out_submit_order(String productName) throws InterruptedException {
        CartPage cartPage = productCatalogue.gotoCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        Thread.sleep(2000);
        productCatalogue.clickCartButton();
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        Thread.sleep(2000);
        checkoutPage.selectCountry("india");
        confirmationPage = checkoutPage.submitButton();
    }
    @Then("{string} message is displayed on ConfirmationsPage")
    public void message_displayed_on_ConfirmationsPage(String string){
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
        driver.close();
    }

    @Then("{string} message is displayed")
    public void error_message_is_displayed(String expectedMessage) {
        String actualMessage = landingPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
        driver.close();
    }





}
