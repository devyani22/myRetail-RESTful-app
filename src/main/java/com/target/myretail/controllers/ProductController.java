package com.target.myretail.controllers;

import com.target.myretail.domain.Price;
import com.target.myretail.domain.Product;
import com.target.myretail.service.ProductService;
import com.target.myretail.utils.ApiResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * ProductController.java - This class contains API methods for Product related details
 * @author Devyani
 */
@RestController
@RequestMapping("/products")
class ProductController {
    private static final String PRODUCT_RESOURCE_URL = "https://redsky.target.com/v2/pdp/tcin";
    private static final Currency currency = Currency.getInstance(Locale.getDefault());

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/name/{id}")
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
        String newResponse = (String) product_description.get("title");

        return new ResponseEntity<>(newResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProductDetails(@PathVariable("id") int id) {

        // get product name
        ResponseEntity<?> response = getNameById(id);

        if (response == null || response.getBody() == null) {
            return new ResponseEntity<>(new ApiResponse("Product: " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        Product product = new Product();
        product.setProductName(response.getBody().toString());
        product.setProductId(id);

        // get product price
        Optional<Price> optional = productService.findPriceById(id);
        optional.ifPresent(price -> product.setCurrentPrice(optional.get()));

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<?> updatePrice(@PathVariable("id") int id, @RequestBody Price price) {
        Price response = productService.updateProductPrice(price);

        if (response == null) {
            return new ResponseEntity<>(new ApiResponse("Product: " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/prices")
    ResponseEntity<?> getAllPrices() {
        List<Price> response = productService.findAll();

        if (response == null) {
            return new ResponseEntity<>(new ApiResponse("No products available"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/prices/{id}")
    ResponseEntity<?> getPriceById(@PathVariable("id") int id) {
        Optional<Price> response = productService.findPriceById(id);

        if (!response.isPresent()){
            return new ResponseEntity<>(new ApiResponse("Product: " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(response.get(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/prices/{id}")
    void deletePriceById(@PathVariable("id") int id, @RequestBody Price price) {
       productService.deletePriceById(id);
    }

    @DeleteMapping(value = "/prices")
    void deletePrices() {
        productService.deletePrices();
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(Exception ex) {
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
