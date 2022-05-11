package stepdef;

import context.TestContext;
import domainobjects.BillingDetails;
import enums.ENDPOINTS;
import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.StorePage;

public class CustomerStepDef {

    private final TestContext context;
    private final StorePage storePage;

    public CustomerStepDef(TestContext context) {
        this.context = context;
        this.storePage = PageFactoryManager.getStorePage(context.driver);

    }


    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        // driver = DriverManager.getDriver();
        storePage.load(ENDPOINTS.CHECKOUT.url);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.context.billingDetails = billingDetails;
    }

}
