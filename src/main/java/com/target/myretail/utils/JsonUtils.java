package com.target.myretail.utils;
import java.util.Set;
import org.json.JSONObject;

/**
 * Utility class to perform operations on the JSON response such as retrieving specific key value pair recursively
 * @author Devyani
 */
public class JsonUtils {

    private static String productTitle;

    public static String getProductTitle() {
        return productTitle;
    }

    /**
     * Parses JSONObject received from API response for a specific key recursively.
     * This is the equivalent of doing -
     *
     *     JSONObject jsonObject = new JSONObject(response);
     *     JSONObject product = (JSONObject) jsonObject.get("product");
     *     JSONObject item = (JSONObject) product.get("item");
     *     JSONObject product_description = (JSONObject) item.get("product_description");
     *     String productName = (String) product_description.get("title");
     *
     * @param key
     * @param keyValue
     * @param item
     */
    private static void parseJSONObject(String key, Object keyValue, String item) {
        if (keyValue instanceof JSONObject) {
            JSONObject nextItems = (JSONObject) keyValue;
            Set<String> keySet = nextItems.keySet();
            for (String keyS : keySet) {
                Object objectValue = nextItems.get(keyS);
                parseJSONObject(keyS, objectValue, item);
            }
        } else if (keyValue instanceof String) {
            if (key.equalsIgnoreCase(item)){
                productTitle =  String.valueOf(keyValue);
            }
        }
    }

    /**
     * Returns the value of the specific item from the api response json string
     * @param response
     * @return
     */
    public static void getValueFromResponse(String response, String item) {
        JSONObject jsonObject = new JSONObject(response);
        Set<String> keys = jsonObject.keySet();

        for (String key : keys) {
            Object keyValueObject = jsonObject.get(key);
            parseJSONObject(key, keyValueObject, item);
        }
    }
}
