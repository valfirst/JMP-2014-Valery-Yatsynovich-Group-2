package com.epam.manager;

import com.epam.exception.BankException;
import com.epam.model.*;

/**
 * Created by Юлия on 10/25/14.
 */
public class Manager extends Thread {

    private Bank bank;
    private Person person;
    private CurrencyType currencyType;
    private boolean flag = true;

    public Manager(Bank bank1, Person person, CurrencyType currencyType) throws BankException {
        if(bank1 == null || person == null || currencyType == null){
            throw new BankException("Manager is not configured properly." +
                    "One of person|bank|currencyType is not");
        }
        this.bank = bank1;
        this.person = person;
        this.currencyType = currencyType;
    }

    @Override
    public void run(){
        while(flag){
         Currency currency = bank.getCurrency(currencyType);
         Account account = new Account(currency);
         account.setType("Mortgage");
         System.out.println("account id is --> " + account.getId());
         System.out.println("currency rate is --> " + account.getCurrency().getExchangeRate());


         System.out.println("Manager is sleeping ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopManager(){
        System.out.println("Manager is going home.");
        this.flag = false;
        this.interrupt();
    }

}
