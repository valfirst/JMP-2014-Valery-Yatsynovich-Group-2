package newmain;

import mainnew.CurrencyExchangeRate;
import manager.Manager;
import exception.BankException;
import Model.Bank;
import Model.CurrencyType;
import Model.Person;


/**
 * Created by Julia on 10/25/14.
 */
class Main {

    public static void main(String[] args) throws BankException {

        Bank bank = new Bank();
        new Thread((Runnable) new CurrencyExchangeRate("bank", bank)).start();
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
