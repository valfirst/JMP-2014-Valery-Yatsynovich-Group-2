package com.epam.model;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Julia on 11/1/14.
 */
public interface IBank {

    void changeCurrencyRate();
    CopyOnWriteArraySet<Currency> getCurrencyRate();
    Currency getCurrency(CurrencyType currencyType);

}
