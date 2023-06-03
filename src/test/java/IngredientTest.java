import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

public class IngredientTest {
    private Ingredient ingredient;
    @Before
    public void setUp(){
        ingredient = new Ingredient(FILLING, "dinosaur", 200);
    }

    @Test
    public void ingredientGetTypeReturnFILLING(){
        String expected = "FILLING";
        String actual = String.valueOf(ingredient.getType());
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getNameReturnIngredientName(){
        String expected = "dinosaur";
        String actual = ingredient.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPriceReturnIngredientPrice(){
        float expected = 200;
        float actual = ingredient.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }
}
