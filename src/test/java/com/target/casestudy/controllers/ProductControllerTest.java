package com.target.casestudy.controllers;

import com.target.casestudy.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;


    @Test
    public void getNameById() {
        int id = 13860428;
        ResponseEntity<?> name = productController.getNameById(id);
    }

    @Test
    public void updatePrice() {
    }
}