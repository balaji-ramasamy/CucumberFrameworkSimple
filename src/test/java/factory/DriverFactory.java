package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.function.Supplier;

public class DriverFactory {
    private static final HashMap<String, Supplier<WebDriver>> MAP = new HashMap<>();

    private final static Supplier<WebDriver> CHROMEDRIVER = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    private final static Supplier<WebDriver> FIREFOXDRIVER = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    static{
        MAP.put("chrome", CHROMEDRIVER);
        MAP.put("firefox", FIREFOXDRIVER);
    }

    public static WebDriver getDriver(String browserName){
        return MAP.get(browserName).get();
    }



}
