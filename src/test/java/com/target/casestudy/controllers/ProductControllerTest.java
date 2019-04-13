package com.target.casestudy.controllers;

import com.target.casestudy.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    ProductService productService;

    @InjectMocks
    ProductController productController;


    @Test
    public void getNameById() {
        Long id = 111l;
        when(productService.findNameById(id)).thenReturn("Jason Bourne");
        String name = productController.getNameById(id).getBody().toString();
        assertNotNull(productController.getNameById(id));
        assertNotNull(productController.getNameById(id).getBody());
        assertEquals("Jason Bourne",name);
        assertEquals(HttpStatus.OK.value(),productController.getNameById(id).getStatusCodeValue());
    }

    @Test
    public void updatePrice() {
    }
}