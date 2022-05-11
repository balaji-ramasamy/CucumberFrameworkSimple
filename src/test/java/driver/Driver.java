package driver;

import driver.drivermanager.DriverManager;
import factory.DriverFactory;

import java.util.Objects;

public class Driver {


    /*public static void init(String browserName) {
        if (Objects.isNull(DriverManager.getDriver()))
            DriverManager.setDriver(DriverFactory.getDriver(browserName));
    }*/

    /**
     * using pico container
     */

    public static void init(String browserName) {
        if (Objects.isNull(DriverManager.getDriver()))
            DriverManager.setDriver(DriverFactory.getDriver(browserName));
    }


    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
