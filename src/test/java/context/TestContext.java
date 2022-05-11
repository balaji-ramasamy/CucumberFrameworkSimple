package context;

import domainobjects.BillingDetails;
import domainobjects.Cookies;
import org.openqa.selenium.WebDriver;

public class TestContext {

    public WebDriver driver;
    public BillingDetails billingDetails;
    public Cookies cookies;

    public TestContext() {
        this.cookies = new Cookies();
        this.cookies.setCookies(new io.restassured.http.Cookies());
    }
}
