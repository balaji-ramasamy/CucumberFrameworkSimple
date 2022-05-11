package stepdef;

import api.CartApi;
import context.TestContext;
import domainobjects.Product;
import enums.ENDPOINTS;
import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.StorePage;

public class StoreStepDef {

    private final StorePage storePage;
    private final TestContext context;

    public StoreStepDef(TestContext context) {
        this.context = context;
        storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I'm on the Store page")
    public void i_m_on_the_store_page() {
        //driver = DriverManager.getDriver();
        storePage.load( ENDPOINTS.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        storePage.addToCart(product.getProductName());
    }

    @And("I have a {product} in the cart")
    public void iHaveAProductInTheCart(Product product) {

   //     storePage.load(ENDPOINTS.STORE.url);
     //   storePage.addToCart(product.getProductName());

        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215,1);
        this.context.cookies.setCookies(cartApi.getCookies());
        this.context.cookies.injectCookies(this.context.driver);

    }

}
