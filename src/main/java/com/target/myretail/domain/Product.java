package com.target.myretail.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Product.java - This is the java bean for Product details
 * @author Devyani
 */
public class Product {

    @JsonProperty(value = "id")
    private int productId;

    @JsonProperty(value = "name")
    private String productName;

    @JsonProperty(value = "current_price")
    private Price currentPrice;

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Price getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Price currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
