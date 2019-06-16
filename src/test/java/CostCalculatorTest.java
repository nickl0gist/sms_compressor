import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CostCalculatorTest {

    @Test
    public void calculator_test(){
        CostCalculator costCalculator = new CostCalculator(new BigDecimal(2.5));
        Assert.assertEquals(costCalculator.calculate(5), new BigDecimal(12.5));
    }

}
