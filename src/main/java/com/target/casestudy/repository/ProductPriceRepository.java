package com.target.casestudy.repository;

import com.target.casestudy.domain.Price;

/**
 * This is the custom Spring Data implementation for CRUD operations on MongoDB document Price
 * @author Devyani
 */
public interface ProductPriceRepository {

    Price findPriceById(Long id);

    void updatePriceById(Long id);
}

