package com.s22617.nbpevaluator.model;

public class Rate {
    String nr;
    String effectiveDate;
    Double mid;

    public Rate() {
    }

    public Rate(String nr, String effectiveDate, Double mid) {
        this.nr = nr;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }
}
