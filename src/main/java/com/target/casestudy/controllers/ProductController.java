package com.target.casestudy.controllers;

import com.target.casestudy.service.ProductService;
import com.target.casestudy.utils.ApiResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;

/**
 * ProductController.java - This class contains API methods for Product related details
 * @author Devyani
 */
@RestController
@RequestMapping("/products")
class ProductController {
    private static final String PRODUCT_RESOURCE_URL = "https://redsky.target.com/v2/pdp/tcin";

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getNameById(@PathVariable("id") int id) {

        String response
                = restTemplate().getForObject(PRODUCT_RESOURCE_URL+ "/" + id + "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", String.class);

        if (response == null) {
            return new ResponseEntity<>(new ApiResponse("Product: " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        JSONObject jsonObject = new JSONObject(response);

        JSONObject product = (JSONObject) jsonObject.get("product");
        JSONObject item = (JSONObject) product.get("item");
        JSONObject product_description = (JSONObject) item.get("product_description");
        String title = (String) product_description.get("title");

        return new ResponseEntity<>(title, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePrice(){}

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
