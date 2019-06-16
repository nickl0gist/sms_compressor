import org.junit.Assert;
import org.junit.Test;

public class NativeCompressorTest {

    @Test
    public void compress_deCompress(){
       NativeCompressor nc = new NativeCompressor();
        Assert.assertTrue(nc.compress("Ala ma kota w Worku").equals("AlaMaKotaWWorku"));
        Assert.assertTrue(nc.deCompress("AlaMaKotaWWorku").equals("Ala Ma Kota W Worku"));
    }
}
