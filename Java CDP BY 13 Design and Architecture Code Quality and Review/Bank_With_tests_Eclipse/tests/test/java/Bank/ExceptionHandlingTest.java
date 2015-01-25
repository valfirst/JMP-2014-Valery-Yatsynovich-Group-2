package test.java.Bank;

import mainnew.CurrencyExchangeRate;
import exception.BankException;
import manager.Manager;
import Model.Bank;
import Model.CurrencyType;
import Model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Julia on 11/1/14.
 */
@RunWith(org.junit.runners.JUnit4.class)
public class ExceptionHandlingTest extends Assert{

    @Test(expected = BankException.class)
    public void managerTestNullPerson() throws BankException {
        new Manager(new Bank(), null, CurrencyType.BYR);
    }

    @Test(expected = BankException.class)
    public void managerTestNull() throws BankException {
        new Manager(null, new Person(), CurrencyType.BYR);
    }

    @Test(expected = BankException.class)
    public void currencyTypeIsNull() throws BankException {
        new Manager(new Bank(), new Person(), null);
    }

    @Test(expected = BankException.class)
    public void allNull() throws BankException {
        new Manager(null, null, null);
    }

    @Test(expected = BankException.class)
    public void bankNullInCurrencyExcRate() throws BankException {
        new CurrencyExchangeRate(" some name", null);
    }
}
