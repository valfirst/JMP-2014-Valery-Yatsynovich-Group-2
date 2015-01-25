package test.java.Bank;

import java.util.concurrent.CopyOnWriteArraySet;

import junit.framework.Assert;
import mainnew.CurrencyExchangeRate;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import exception.BankException;
import Model.Bank;
import Model.Currency;
import Model.CurrencyType;

/**
 * Created by Julia on 11/1/14.
 */
@RunWith(org.junit.runners.JUnit4.class)
public class BankTest extends Assert{

    private static final Bank bank = new Bank();
    private static CopyOnWriteArraySet<Currency> list = null;
    private static Currency currencyEUR = null;
    private static Currency currencyBYR = null;
    private static Thread thread;


    @BeforeClass
    public static void setUp() throws BankException {
        list =  bank.getCurrencyRate();
        CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate("test thread", bank);
        thread = new Thread(currencyExchangeRate);
        thread.start();
    }

    @Before
    public void beforeTest(){
        currencyEUR = bank.getCurrency(CurrencyType.EUR);
        currencyBYR = bank.getCurrency(CurrencyType.BYR);
    }

    @Test
    public void currencySize(){
        assertEquals("Assert currency size", 4, list.size());
    }

    @Test
    public void currencyEURChanged() throws InterruptedException {
        int before = currencyEUR.getExchangeRate();
        Thread.sleep(6000);
        Currency currencyEURnew = bank.getCurrency(CurrencyType.EUR);
        int after = currencyEURnew.getExchangeRate();
        assertNotSame("currency has changed", before, after);
    }

    @Test
    public void currencyBYRNotChanged() throws InterruptedException {
        int before = currencyBYR.getExchangeRate();
        Thread.sleep(6000);
        Currency currencyBYRnew = bank.getCurrency(CurrencyType.BYR);
        int after = currencyBYRnew.getExchangeRate();
        assertSame("currency has changed", before, after);
    }

    @Test
    public void stopCurrencyChange() throws InterruptedException {
        int before = bank.getCurrency(CurrencyType.EUR).getExchangeRate();
        thread.stop();
        Thread.sleep(6000);
        int after = bank.getCurrency(CurrencyType.EUR).getExchangeRate();
        assertEquals("Currency rate has not been changed", before, after);

    }
}
