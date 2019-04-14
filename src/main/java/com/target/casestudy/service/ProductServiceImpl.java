package com.target.casestudy.service;

import com.target.casestudy.domain.Price;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl.java - This class contains implementation of service methods that perform the main
 * business logic and/or interact with the database for various CRUD operations
 * @author Devyani
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    public static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Price findPriceById(int id) {
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String findNameById(int id) {
        // placeholder
        return "Hello: "+ id;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Price updatePriceById(int id) {
        return null;
    }

    /**
     *
     * @param id
     */
    @Override
    public void deletePriceById(int id) {

    }
}
