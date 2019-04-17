package com.target.casestudy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

/**
 * Price.java - This is the entity class for Product price and currency details that will be persisted on to the database
 * @author Devyani
 */
public class Price {

    @JsonIgnore
    @Id
    private int id;

    @JsonProperty(value = "value")
    private BigDecimal value;

    @JsonProperty(value = "currency_code")
    private String currency_code;

    public Price() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }
}
