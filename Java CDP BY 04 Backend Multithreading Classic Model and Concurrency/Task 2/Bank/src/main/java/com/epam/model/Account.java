package com.epam.model;

/**
 * Created by Юлия on 10/25/14.
 */
public class Account {

    private double id;
    private String type;
    private Currency currency;

    public Account(){}

    public Account(Currency currency){
        this.id = Math.random();
        this.currency = currency;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", currency=" + currency +
                '}';
    }
}
