import org.junit.Assert;
import org.junit.Test;

public class AdvancedCompressorTest {
    @Test
    public void compress_deCompress(){
        AdvancedCompressor nc = new AdvancedCompressor();
        //Assert.assertTrue(nc.compress("Ala ma kota w Worku").equals("AlaMaKotaWWorku"));
        //Assert.assertTrue(nc.deCompress("AlaMaKotaWWorku").equals("Ala Ma Kota W Worku"));
        System.out.println(nc.compress("Ala ma kota w Worku"));
        System.out.println(nc.deCompress(nc.compress("Ala ma kota w Worku")));
    }
}

