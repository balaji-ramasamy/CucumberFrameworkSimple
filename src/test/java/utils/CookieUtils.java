package utils;

import io.restassured.http.Cookies;
import org.openqa.selenium.Cookie;

import java.util.ArrayList;
import java.util.List;

public class CookieUtils {

    public static List<Cookie> getCookies(Cookies raCookies){
        List<Cookie> seCookies = new ArrayList<>();
        List<io.restassured.http.Cookie> raC = raCookies.asList();
        for (io.restassured.http.Cookie c: raC){
            seCookies.add(new Cookie(c.getName(),c.getValue(),c.getDomain(),c.getPath(),c.getExpiryDate(),
                    c.isSecured(),c.isHttpOnly(),c.getSameSite()));
        }
        return seCookies;
    }
}
