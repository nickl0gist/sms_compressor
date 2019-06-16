import jsmaz.Smaz;

import java.nio.charset.StandardCharsets;

public class AdvancedCompressor implements Compressor {

    private Smaz smaz = new Smaz();

    @Override
    public String compress(String text) {
        return new String(smaz.compress(text), StandardCharsets.ISO_8859_1);
    }

    @Override
    public String deCompress(String text) {
        return smaz.decompress(text.getBytes(StandardCharsets.ISO_8859_1));
    }
}
