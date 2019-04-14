package com.target.casestudy.service;

import com.target.casestudy.domain.Price;
import org.springframework.stereotype.Service;

/**
 * ProductService.java - This class contains service methods that perform the main business logic and/or interact
 * with the database for various CRUD operations
 * @author Devyani
 */
@Service
public interface ProductService {

    Price findPriceById(int id);

    String findNameById(int id);

    Price updatePriceById(int id);

    void deletePriceById(int id);

}
