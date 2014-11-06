package com.epam.currencyrate;

import com.epam.exception.BankException;
import com.epam.model.Bank;

/**
 * Created by Julia on 10/25/14.
 */
public class CurrencyExchangeRate extends Thread {

    private boolean rateIsChanging = true;
    private Bank bank;

    public CurrencyExchangeRate(String threadName, Bank bank1) throws BankException {
        if(bank != null){
            throw new BankException("Bank can not be null");
        }
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
