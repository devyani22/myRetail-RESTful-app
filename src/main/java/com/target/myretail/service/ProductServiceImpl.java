package com.target.myretail.service;

import com.target.myretail.domain.Price;
import com.target.myretail.repository.ProductPriceRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * ProductServiceImpl.java - This class contains implementation of service methods that perform the main
 * business logic and/or interact with the database for various CRUD operations
 * @author Devyani
 */
@Service
public class ProductServiceImpl implements ProductService {

    public static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private static final Currency currency = Currency.getInstance(Locale.getDefault());

    @Autowired
    ProductPriceRepository productPriceRepository;

    /**
     * Lookup by id
     * @param id
     * @return
     */
    @Override
    public Optional<Price> findPriceById(int id) {
        return productPriceRepository.findById(id);
    }

    /**
     * Save or Update a single record
     * @param price
     * @return
     */
    @Override
    public Price updateProductPrice(Price price) {
        return productPriceRepository.save(price);
    }

    /**
     * Delete record by id
     * @param id
     */
    @Override
    public void deletePriceById(int id) {
        productPriceRepository.deleteById(id);
    }

    /**
     * Delete all records in Price document
     */
    @Override
    public void deletePrices() {
        productPriceRepository.deleteAll();
    }

    /**
     * Retrieve all records in Price document
     * @return
     */
    @Override
    public List<Price> findAll() {
        return productPriceRepository.findAll();
    }

    /**
     *
     * @param key
     * @param keyValue
     */
    private void parseJSONObject(String key, Object keyValue) {
        String name = null;
        if (keyValue instanceof JSONObject) {
            JSONObject nextItems = (JSONObject) keyValue;
            Set<String> keySet = nextItems.keySet();
            for (String keyS : keySet) {
                Object objectValue = nextItems.get(keyS);
                parseJSONObject(keyS, objectValue);
            }
        } else if (keyValue instanceof String) {
            if (key.equalsIgnoreCase("title")){
                name = String.valueOf(keyValue);
            }
            //System.out.println("Key :: " + key + ", Value :: " + keyValue);
        }
    }

    /**
     * Returns the name of the product from the api response json string
     * @param response
     * @return
     */
    public String getTitleFromResponse(String response) {
        JSONObject jsonObject = new JSONObject(response);
        Set<String> keys = jsonObject.keySet();

        for (String key : keys) {
          Object keyValueObject = jsonObject.get(key);
           parseJSONObject(key, keyValueObject);
        }
        return null;
    }
}
