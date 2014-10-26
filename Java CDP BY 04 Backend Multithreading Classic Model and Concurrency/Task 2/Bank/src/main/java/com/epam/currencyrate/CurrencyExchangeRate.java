package com.epam.currencyrate;

import com.epam.manager.Manager;
import com.epam.model.Bank;
import com.epam.model.Currency;
import com.epam.model.CurrencyType;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Юлия on 10/25/14.
 */
public class CurrencyExchangeRate extends Thread {

    private boolean rateIsChanging = true;
    private Bank bank;

    public CurrencyExchangeRate(String threadName, Bank bank1){
        this.setName(threadName);
        this.bank = bank1;
    }

    @Override
    public void run() {
       while(this.rateIsChanging){
           System.out.println("Rate is going to be changed now");
           try {
               bank.changeCurrencyRate();
               System.out.println("Rate is frozen for 3000 mls");
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    public void stopCurrencyChanging(){
        System.out.println("Currency is NOT going to change any more.....");
        this.rateIsChanging = false;
        this.interrupt();
    }
}
