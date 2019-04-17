package com.target.casestudy.repository;

import com.target.casestudy.domain.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * This is the custom Spring Data implementation for CRUD operations on MongoDB document Price
 * @author Devyani
 */
public interface ProductPriceRepository extends MongoRepository<Price, Integer> {

}

