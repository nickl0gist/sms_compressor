import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        NativeCompressor nativeCompressor = new NativeCompressor();
        Paginator paginator = new Paginator(Integer.parseInt(args[1]));
        CostCalculator costCalculator = new CostCalculator(new BigDecimal(args[2]));

        String compressedMessage = nativeCompressor.compress(args[0]);
        int messageQty = paginator.paginate(compressedMessage).length;
        BigDecimal cost = costCalculator.calculate(messageQty);

        System.out.println("Your message after compression: \n" + compressedMessage);
        System.out.printf("It will be splitted to %s sms \n", messageQty);
        System.out.println("The total cost of all sms is " + cost);


    }
}
