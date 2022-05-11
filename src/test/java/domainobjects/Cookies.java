package domainobjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.CookieUtils;

import java.util.List;

public class Cookies {

    private io.restassured.http.Cookies cookies;

    public io.restassured.http.Cookies getCookies() {
        return cookies;
    }

    public void setCookies(io.restassured.http.Cookies cookies) {
        this.cookies = cookies;
    }

    public void injectCookies(WebDriver driver){
        List<Cookie> seCookies = CookieUtils.getCookies(getCookies());
        for (Cookie c: seCookies){
            driver.manage().addCookie(c);
        }
        driver.navigate().refresh();
    }
}
