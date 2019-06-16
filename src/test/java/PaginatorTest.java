import org.junit.Assert;
import org.junit.Test;

public class PaginatorTest {
    @Test
    public void paginate_test(){
        Paginator paginator = new Paginator(3);
        Assert.assertEquals(paginator.paginate("AlaMaKotaWWorku").length, 5);
    }
}
