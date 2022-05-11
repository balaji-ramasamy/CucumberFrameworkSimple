package hooks;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class CustomHooks {
    private TestContext context;
    private WebDriver driver;

    public CustomHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void before() {
      //  Driver.init(System.getProperty("browser", "chrome"));
       // DriverManager.getDriver();
        //using pico container
        this.driver = DriverFactory.getDriver(System.getProperty("browser", "chrome"));
        context.driver = this.driver;
    }

    @After
    public void after() {
        //Driver.quitDriver();

        //using pico container
        driver.quit();
    }
}
