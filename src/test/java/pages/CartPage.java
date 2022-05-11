package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By productName = By.cssSelector("td.product-name");
    private final By productQty = By.cssSelector("input[title='Qty']");
    private final By checkoutBtn = By.cssSelector("a.checkout-button");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

   /* public void load(String endpoint){
        this.webDriver.get(endpoint);
    }*/

    public String getProductName(){
       return this.webDriver.findElement(this.productName).getText();
    }

    public int getProductQty(){
       return Integer.parseInt(this.webDriver.findElement(productQty).getAttribute("value"));
    }

    public void checkout(){
        this.webDriver.findElement(checkoutBtn).click();
    }
}
