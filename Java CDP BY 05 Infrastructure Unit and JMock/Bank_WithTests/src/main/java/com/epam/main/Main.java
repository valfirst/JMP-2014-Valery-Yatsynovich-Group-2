package com.epam.main;

import com.epam.currencyrate.CurrencyExchangeRate;
import com.epam.exception.BankException;
import com.epam.manager.Manager;
import com.epam.model.Account;
import com.epam.model.Bank;
import com.epam.model.CurrencyType;
import com.epam.model.Person;

/**
 * Created by Julia on 10/25/14.
 */
public class Main {

    public static void main(String[] args) throws BankException {

        Bank bank = new Bank();
        new Thread(new CurrencyExchangeRate("First", bank)).start();
        Person personOne = new Person();
        Person personTwo = new Person();
        Person personThree = new Person();
        Person personFour = new Person();

        new Thread(new Manager(bank, personOne, CurrencyType.EUR)).start();
        new Thread(new Manager(bank, personTwo, CurrencyType.EUR)).start();
        new Thread(new Manager(bank, personThree, CurrencyType.BYR)).start();
        new Thread(new Manager(bank, personFour, CurrencyType.RU)).start();



    }

}
