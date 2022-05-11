package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage{

    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void load(String endpoint){
       super.load(endpoint);
    }

    public void addToCart(String productName){
       /* String raw ="a[aria-label='Add “\"+productName+\"” to your cart']";
        byte[] byteArr = raw.getBytes(StandardCharsets.UTF_8);
        String op = new String(byteArr, StandardCharsets.UTF_8)*/
        By productBtn = By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
        this.webDriver.findElement(productBtn).click();
        this.webDriverWait.until(d -> d.findElement(viewCartLink).isDisplayed());
        this.webDriver.findElement(viewCartLink).click();
    }

}
