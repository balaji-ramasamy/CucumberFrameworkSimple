package stepdef;

import context.TestContext;
import enums.ENDPOINTS;
import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CheckoutPage;

public class CheckoutStepDef {

    private final TestContext context;
    private final CheckoutPage checkoutPage;

    public CheckoutStepDef(TestContext context) {
        this.context = context;
        this.checkoutPage = PageFactoryManager.getCheckoutPage(this.context.driver);
    }


    @When("I provide the billing details")
    public void iProvideTheBillingDetails() {
        this.checkoutPage
                .enterBillingFirstName(this.context.billingDetails.getBillingFirstName())
                .enterBillingLastName(this.context.billingDetails.getBillingLastName())
                .enterBillingStreetAddress(this.context.billingDetails.getBillingAddressOne())
                .enterBillingCity(this.context.billingDetails.getBillingCity())
                .setBillingState(this.context.billingDetails.getBillingStateName())
                .enterBillingZip(this.context.billingDetails.getBillingZip())
                .enterBillingEmail(this.context.billingDetails.getBillingEmail());
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        this.checkoutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {

        Assert.assertEquals("Thank you. Your order has been received.", this.checkoutPage.getNotice());
    }

    @And("I'm on the checkout page")
    public void iMOnTheCheckoutPage() {
        checkoutPage.load(ENDPOINTS.CHECKOUT.url);
    }
}
