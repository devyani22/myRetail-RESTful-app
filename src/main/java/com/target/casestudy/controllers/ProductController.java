package com.target.casestudy.controllers;

import com.target.casestudy.service.ProductService;
import com.target.casestudy.utils.ApiResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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

        ResponseEntity<String> response
                = restTemplate().getForEntity(PRODUCT_RESOURCE_URL+ "/" + id, String.class);

        if (response == null) {
            return new ResponseEntity<>(new ApiResponse("Product: " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        JSONObject jsonObject = new JSONObject(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePrice(){}

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
