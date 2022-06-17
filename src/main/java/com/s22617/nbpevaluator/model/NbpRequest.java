package com.s22617.nbpevaluator.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@ApiModel(value = "Inserted NBP request to table", description = "Something something")
public class NbpRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Unique ID of request", required = true)
    private Integer id;
    @ApiModelProperty(value = "Currency code", required = true)
    private String currency;
    @ApiModelProperty(value = "Number of days to get average currency exchange rate from", required = true)
    private Integer days;
    @ApiModelProperty(value = "Calculated average exchange rate", required = true)
    private Double exchangeRate;
    @ApiModelProperty(value = "Time of the request", required = true)
    private LocalDateTime date;

    public NbpRequest() {
    }

    public NbpRequest(Integer id, String currency, Integer days, Double exchangeRate, LocalDateTime date) {
        this.id = id;
        this.currency = currency;
        this.days = days;
        this.exchangeRate = exchangeRate;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
