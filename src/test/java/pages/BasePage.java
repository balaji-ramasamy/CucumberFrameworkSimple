package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public void load(String endpoint){
        this.webDriver.get(ConfigLoader.getConfigLoader().get("baseurl")+endpoint);
    }

    public void enterText(By locator, String inputText){
        this.webDriver.findElement(locator).clear();
        this.webDriver.findElement(locator).sendKeys(inputText);
    }

    public void waitForOverlayToDisappear(By locator){
        List<WebElement> overlays = this.webDriver.findElements(locator);
        if(overlays.size()>0){
            this.webDriverWait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
        }

    }
}
