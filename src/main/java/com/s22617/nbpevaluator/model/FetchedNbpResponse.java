package com.s22617.nbpevaluator.model;

import java.util.List;

public class FetchedNbpResponse {
    String table;
    String currency;
    List<Rate> rates;

    public FetchedNbpResponse() {
    }

    public FetchedNbpResponse(String table, String currency, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
