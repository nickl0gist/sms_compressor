import java.math.BigDecimal;

import picocli.CommandLine;
import picocli.CommandLine.*;
import picocli.CommandLine.Parameters;

@Command(description = "Compressing test to short messages using Native and Advanced methods",
        name = "sms_compress", mixinStandardHelpOptions = true)

public class Main implements Runnable{

    @Option(names = { "-m", "--message" }, description = "Text message [Please use \"\"]", required = true)
    private static String message;

    @Option(names = { "-l", "--length" }, description = "Length of single text message [number of characters] ",
            required = true)
    private static int length;

    @Option(names = { "-p", "--price" }, description = "Price of single text message [PLN]")
    private static double price;

    @Option(names = "-n", description = "Naive compressor turning on [Please use -n or -o]")
    private static boolean naiveCompressor;

    @Option(names = "-o", description = "Optimal compressor turning on [Please use -n or -o]")
    private static boolean optimalCompressor;

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
    }

    @Override
    public void run() {
        Paginator paginator = new Paginator(length);
        CostCalculator costCalculator = new CostCalculator(new BigDecimal(price));
        Compressor compressor = optimalCompressor ?  new AdvancedCompressor(): new NativeCompressor();
        String compressedMessage = compressor.compress(message);
        String[] sms_messages = paginator.paginate(compressedMessage);
        BigDecimal cost = costCalculator.calculate(sms_messages.length);

        StringBuilder sb = new StringBuilder();
        sb.append("Your message after compression: \n" + compressedMessage);
        sb.append(String.format("It will be splited to %s sms: \n", sms_messages.length));
        for (String s: sms_messages) {
            sb.append(s+"\n");
        }
        sb.append("The total cost of all sms is " + cost + "\n");
        sb.append("The message after decompression is [" + compressor.deCompress(compressedMessage) + "]");

        System.out.println(sb.toString());
    }
}
