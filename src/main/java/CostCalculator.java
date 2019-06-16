import java.math.BigDecimal;

public class CostCalculator {

    private final BigDecimal priceOfSms;

    public CostCalculator(BigDecimal priceOfSms) {
        this.priceOfSms = priceOfSms;
    }

    public BigDecimal calculate(int pageQty) {
        return priceOfSms.multiply( new BigDecimal(pageQty));
    }
}
