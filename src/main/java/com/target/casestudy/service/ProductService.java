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

    Price findPriceById(Long id);

    String findNameById(Long id);

    Price updatePriceById(Long id);

    void deletePriceById(Long id);

}
