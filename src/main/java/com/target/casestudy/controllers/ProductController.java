package com.target.casestudy.controllers;

import com.target.casestudy.service.ProductService;
import com.target.casestudy.utils.ApiResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ProductController.java - This class contains API methods for Product related details
 * @author Devyani
 */
@RestController
@RequestMapping("/products")
@NoArgsConstructor
class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getNameById(@PathVariable("id") Long id) {

        String name = productService.findNameById(id);

        if (name == null) {
            return new ResponseEntity(new ApiResponse("Product: " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(name, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePrice(){}
}
