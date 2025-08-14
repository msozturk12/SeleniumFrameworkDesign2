package inarAcademy.tests;

import inarAcademy.TestComponent.BaseTest;
import inarAcademy.TestComponent.Retry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.CartPage;
import pageobject.ProductCatalogue;

import java.io.IOException;
import java.util.List;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)

    public void submitOrder() throws IOException, InterruptedException {

        landingPage.loginApplication("Test123@gmail.com", "Test123");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

    }

    @Test
    public void ProductErrorValidation() throws InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("Test123@gmail.com", "Test123");
        List<WebElement> product = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.gotoCartPage();
        Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}
