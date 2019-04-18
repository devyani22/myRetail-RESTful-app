package com.target.myretail.service;

import com.target.myretail.domain.Price;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * ProductService.java - This class contains service methods that perform the main business logic and/or interact
 * with the database for various CRUD operations
 * @author Devyani
 */
@Service
public interface ProductService {

    Optional<Price> findPriceById(int id);

    Price updateProductPrice(Price price);

    void deletePriceById(int id);

    void deletePrices();

    List<Price> findAll();



}
