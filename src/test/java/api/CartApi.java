package api;

import enums.ENDPOINTS;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import utils.CookieUtils;

import java.util.HashMap;
import java.util.List;

public class CartApi {

   private Cookies cookies;

    public CartApi(Cookies cookies) {
        this.cookies = cookies;
    }

    public Cookies getCookies() {
        return cookies;
    }

    public void setCookies(Cookies cookies) {
        this.cookies = cookies;
    }

    public Response addToCart(int prodId, int prodQty){
        Header header = new Header("content-type","application/x-www-form-urlencoded");
        Headers headers = new Headers(header);
        HashMap<String,Object> formParams = new HashMap<>();
        formParams.put("product_sku","");
        formParams.put("product_id",prodId);
        formParams.put("quantity",prodQty);
        Response response = ApiRequest.post(ENDPOINTS.ADD_TO_CART.url,headers,formParams,this.cookies);
        if(response.statusCode()!=200){
            throw new RuntimeException("Failed to add product"+prodId+" to the cart."+
                    " HTTP response code is: "+response.statusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;

    }
}
