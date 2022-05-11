package customtype;

import domainobjects.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

    @DataTableType
    public BillingDetails billingDetailsEntry(Map<String, String> entry) {
        return new BillingDetails(entry.get("firstName"),
                entry.get("lastName"),
                entry.get("address_line1"),
                entry.get("city"),
                entry.get("state"),
                entry.get("zip"),
                entry.get("email"));
    }
}
