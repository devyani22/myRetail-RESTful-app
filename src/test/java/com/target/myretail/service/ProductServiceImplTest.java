package com.target.myretail.service;

import com.target.myretail.domain.Price;
import com.target.myretail.repository.ProductPriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {

    @Mock
    ProductPriceRepository productPriceRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void updateProductPrice() {

        Price price = getPrice();

        doReturn(price).when(productPriceRepository).save(any());
        Price response = productService.updateProductPrice(price);

        verify(productPriceRepository, atLeastOnce()).save(any());
        assertNotNull(response);
        assertEquals(111222, response.getId());
        assertEquals("EUR", response.getCurrencyCode());

    }

    private Price getPrice() {
        Price price = new Price();
        price.setId(111222);
        price.setAmount(new BigDecimal(22.22));
        price.setCurrencyCode("EUR");
        return price;
    }

    @Test
    public void deletePriceById() {
        int id = 123456;
        productPriceRepository.deleteById(id);
        productService.deletePriceById(id);

        verify(productPriceRepository, atLeastOnce()).deleteById(id);
    }

    @Test
    public void deletePrices() {
        productPriceRepository.deleteAll();
        productService.deletePrices();

        verify(productPriceRepository, atLeastOnce()).deleteAll();
    }

    @Test
    public void findPriceById() {
        int id = 111222;
        Optional<Price> optional = Optional.of(getPrice());
        doReturn(optional).when(productPriceRepository).findById(id);
        optional = productService.findPriceById(id);

        assertTrue( "valid results returned", optional.isPresent());
        assertNotNull(optional.get());
        assertEquals(id, optional.get().getId());
        assertEquals("EUR", optional.get().getCurrencyCode());

        verify(productPriceRepository).findById(id);
    }
}