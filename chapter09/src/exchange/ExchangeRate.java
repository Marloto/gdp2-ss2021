package exchange;

public class ExchangeRate {
    private final double rate;
    private final String currency;

    public ExchangeRate(double rate, String currency) {
        this.rate = rate;
        this.currency = currency;
    }
    
    public String getCurrency() {
        return currency;
    }
    
    public double getRate() {
        return rate;
    }
}