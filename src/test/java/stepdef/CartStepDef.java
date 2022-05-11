package stepdef;

import context.TestContext;
import domainobjects.Product;
import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;

public class CartStepDef {
    private final CartPage cartPage;

    public CartStepDef(TestContext context) {
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }



    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int qty, Product product) {
        //CartPage cartPage = new CartPage(this.driver);
       /* Assert.assertEquals(cartPage.getProductName(), product.getProductName());
        Assert.assertEquals(cartPage.getProductQty(),qty);*/

        Assert.assertEquals(cartPage.getProductName(), product.getProductName());
        Assert.assertEquals(cartPage.getProductQty(),qty);
    }
}
