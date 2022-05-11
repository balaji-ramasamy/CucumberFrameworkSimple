package enums;

public enum ENDPOINTS {

    STORE("/store"),
    ACCOUNT("/account"),
    ADD_TO_CART("/?wc-ajax=add_to_cart"),
    CHECKOUT("/checkout");

    public final String url;

    ENDPOINTS(String url) {
        this.url=url;
    }
}
