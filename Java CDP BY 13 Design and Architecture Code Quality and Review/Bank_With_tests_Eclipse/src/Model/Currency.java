package Model;

/**
 * Created by Julia on 10/25/14.
 */
public class Currency {

    private CurrencyType currencyType;
    private int exchangeRate;

    public Currency(){
        this.currencyType = CurrencyType.BYR;
        this.exchangeRate = 1;
    }

    public Currency(CurrencyType currencyType, int exchangeRate){
        this.currencyType = currencyType;
        this.exchangeRate = exchangeRate;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public int getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(int exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;

        if (exchangeRate != currency.exchangeRate) return false;
        return currencyType == currency.currencyType;

    }

    @Override
    public int hashCode() {
        int result = currencyType.hashCode();
        result = 31 * result + exchangeRate;
        return result;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyType=" + currencyType +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
