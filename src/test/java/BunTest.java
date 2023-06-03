import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
public class BunTest {
    private Bun bun;
    @Before
    public void setUp(){
        bun = new Bun("white bun", 200);
    }
    @Test
    public void getNameReturnBunName(){
        String expected = "white bun";
        String actualBunName = bun.getName();
        Assert.assertEquals(expected, actualBunName);
    }
    @Test
    public void getPriceReturnBunPrice(){
        float expected = 200;
        float actualBunName = bun.getPrice();
        Assert.assertEquals(expected, actualBunName, 0);
    }
}
