package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    private final By fname = By.id("billing_first_name");
    private final By lname = By.id("billing_last_name");
    private final By streetAddress = By.id("billing_address_1");
    private final By city = By.id("billing_city");
    private final By stateDropDown = By.id("billing_state");
    private final By zip = By.id("billing_postcode");
    private final By email = By.id("billing_email");
    private final By placeOrder = By.id("place_order");
    private final By orderConf = By.cssSelector(".woocommerce-notice");
    private final By stateDropDown2 = By.id("select2-billing_state-container");
    private final By overlayLocator = By.cssSelector("div.blockUI.blockOverlay");


    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CheckoutPage enterBillingFirstName(String firstName) {
        enterText(fname, firstName);
        return this;
    }

    public CheckoutPage enterBillingLastName(String lastName) {
        enterText(lname, lastName);
        return this;
    }

    public CheckoutPage enterBillingStreetAddress(String address) {
        enterText(streetAddress, address);
        return this;
    }

    public CheckoutPage enterBillingCity(String cityName) {
        enterText(city, cityName);
        return this;
    }

    public CheckoutPage enterBillingZip(String zipCode) {
        enterText(zip, zipCode);
        return this;
    }

    public CheckoutPage enterBillingEmail(String emailAddr) {
        enterText(email, emailAddr);
        return this;
    }

    public CheckoutPage setBillingState(String stateName) {

        this.webDriverWait.until(ExpectedConditions.elementToBeClickable(stateDropDown2)).click();
       WebElement e= this.webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='"+stateName+"']")));

        ((JavascriptExecutor)this.webDriver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
       /* Select s = new Select(this.webDriver.findElement(stateDropDown));
        s.selectByVisibleText(stateName);*/
        return this;
    }

    public void placeOrder(){
        waitForOverlayToDisappear(overlayLocator);
        this.webDriver.findElement(placeOrder).click();
    }

    public String getNotice(){
        this.webDriverWait.until(d -> d.findElement(orderConf).isDisplayed());
        return this.webDriver.findElement(orderConf).getText();
    }


}
