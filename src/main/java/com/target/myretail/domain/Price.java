package com.target.myretail.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

/**
 * Price.java - This is the entity class for Product price and currency details that will be persisted on to the database
 * @author Devyani
 */
public class Price {

    private static final Currency currency = Currency.getInstance(Locale.getDefault());
    private static final RoundingMode DEFAULT_ROUNDING = RoundingMode.HALF_EVEN;

    @Id
    private int id;

    @JsonProperty(value = "value")
    private BigDecimal amount;

    @JsonProperty(value = "currency_code")
    private String currencyCode;

    public Price() {
    }

    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount.setScale(currency.getDefaultFractionDigits(), DEFAULT_ROUNDING);
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode != null ? currencyCode : currency.getCurrencyCode();
    }
}
