package inarAcademy.tests;

import inarAcademy.TestComponent.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws IOException, InterruptedException {


        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));

        CartPage cartPage = productCatalogue.gotoCartPage();
        Boolean match = cartPage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        Thread.sleep(2000);
        productCatalogue.clickCartButton();
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        Thread.sleep(2000);
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitButton();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest() {

        //"ZARA COAT 3"
        ProductCatalogue productCatalogue = landingPage.loginApplication("Test123@gmail.com", "Test123");
        OrderPage orderPage = productCatalogue.gotoOrderPage();
        Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));

    }



    @DataProvider
    public Object[][] getData() throws IOException {

       /* HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "Test123@gmail.com");
        map.put("password", "Test123");
        map.put("product", "ZARA COAT 3");

        HashMap<String, String> map1 = new HashMap<String, String>();
        map.put("email", "msozturk12@gmail.com");
        map.put("password", "1234");
        map.put("product", "ADIDAS ORIGINAL"); */

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "\\src\\test\\java\\InarAcademy\\data\\PurchaseOrder.json");
        //C:\Seleniumm\SeleniumFrameworkDesign2\src\test\java\InarAcademy\data\PurchaseOrder.json
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }
}
