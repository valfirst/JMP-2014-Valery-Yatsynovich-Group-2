package com.epam.model;

import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Julia on 10/25/14.
 */
public class Bank implements IBank{
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private CopyOnWriteArraySet<Currency> exchangeRateList = new CopyOnWriteArraySet<Currency>();
    private boolean flag = true;
    private final Lock get  = readWriteLock.readLock();
    private final Lock change = readWriteLock.writeLock();

    {
        Currency currencyBY = new Currency(CurrencyType.BYR, 1);
        Currency currencyUSD = new Currency(CurrencyType.USD, 10200);
        Currency currencyEUR = new Currency(CurrencyType.EUR, 13100);
        Currency currencyRU = new Currency(CurrencyType.RU, 360);
        exchangeRateList.add(currencyBY);
        exchangeRateList.add(currencyUSD);
        exchangeRateList.add(currencyEUR);
        exchangeRateList.add(currencyRU);
    }


    public void changeCurrencyRate(){
        change.lock();
        try{
            for(Currency currency : exchangeRateList){
                if(currency.getCurrencyType() != CurrencyType.BYR){
                    if(flag){
                        flag = false;
                        currency.setExchangeRate(currency.getExchangeRate() + 2);
                        System.out.println("currency " + currency.getCurrencyType() + " : " + currency.getExchangeRate());
                    }
                    else{
                        flag = true;
                        currency.setExchangeRate(currency.getExchangeRate() - 1);
                        System.out.println("currency " + currency.getCurrencyType() + " : " + currency.getExchangeRate());
                    }
                }
            }
        }finally{
            change.unlock();
        }
    }

    public CopyOnWriteArraySet<Currency> getCurrencyRate(){
        get.lock();
        try{
            return exchangeRateList;
        } finally{
            get.unlock();
        }
    }

    public Currency getCurrency(CurrencyType currencyType){
        get.lock();
        try{
            for(Currency currency : exchangeRateList){
                if(currency.getCurrencyType() == currencyType){
                    return currency;
                }
            }
            return null;
        }finally{
            get.unlock();
        }
    }
}
