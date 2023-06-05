import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeParametrizedTest {
    private IngredientType type;
    private String name;
    public IngredientTypeParametrizedTest(IngredientType type, String name){
        this.type = type;
        this.name = name;
    }
    @Parameterized.Parameters(name = "{index} : type = {0}")
    public static Object[][] getData(){
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }
    @Test
    public void enumReturnCorrectName(){
        Assert.assertEquals(name, type.name());
    }
}
