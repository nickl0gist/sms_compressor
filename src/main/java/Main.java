import java.math.BigDecimal;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

public class Main {
    public static void main(String[] args) {

        NativeCompressor nativeCompressor = new NativeCompressor();
        Paginator paginator = new Paginator(Integer.parseInt(args[1]));
        CostCalculator costCalculator = new CostCalculator(new BigDecimal(args[2]));

        String compressedMessage = nativeCompressor.compress(args[0]);
        String[] messages = paginator.paginate(compressedMessage);
        BigDecimal cost = costCalculator.calculate(messages.length);

        StringBuilder sb = new StringBuilder();
        sb.append("Your message after compression: \n" + compressedMessage);
        sb.append(String.format("It will be splited to %s sms: \n", messages.length));
        for (String s: messages) {
            sb.append(s+"\n");
        }
        sb.append("The total cost of all sms is " + cost);

        System.out.println(sb.toString());


    }
}
