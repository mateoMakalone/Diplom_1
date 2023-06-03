import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient hotSauce;
    @Mock
    private Ingredient dinosaur;
    @Mock
    private Ingredient ingredient;

    @Before
    public void setUp(){
        burger = new Burger();
    }
    @Test
    public void setBun(){
        burger.setBuns(bun);
        Bun actual = burger.bun;
        Assert.assertEquals(bun, actual);
    }
    @Test
    public void addIngredientShouldIncreaseList(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        List<Ingredient> actual = burger.ingredients;
        int expectedSize = 2;
        int actualSize = actual.size();
        Assert.assertEquals(expectedSize, actualSize);
    }
    @Test
    public void removeIngredientShouldDeleteIndexField(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.removeIngredient(1);
        List<Ingredient> actual = burger.ingredients;
        int expectedSize = 1;
        int actualSize = actual.size();
        Assert.assertEquals(expectedSize, actualSize);
    }
    @Test
    public void moveIngredientShouldPermuteIngredient(){
        burger.addIngredient(hotSauce);
        burger.addIngredient(dinosaur);
        burger.moveIngredient(0,1);
        Ingredient actual = burger.ingredients.get(0);
        Ingredient expected = dinosaur;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPriceShouldReturnPrice(){
        Mockito.when(bun.getPrice()).thenReturn(300.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        float expected = 1000;
        float actual = burger.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }
    @Test
    public void getReceiptShouldReturnReceipt(){
        Mockito.when(bun.getPrice()).thenReturn(300.0f);
        Mockito.when(bun.getName()).thenReturn("Black Bun");
        burger.setBuns(bun);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");
        Mockito.when(ingredient.getPrice()).thenReturn(200.0f);
        burger.addIngredient(ingredient);
        String expectedReciept =
                "(==== Black Bun ====)\n" +
                "= filling dinosaur =\n" +
                "(==== Black Bun ====)\n" +
                "\n" +
                "Price: 800,000000" +
                "\n";
        String actualReceipt = burger.getReceipt();
        Assert.assertEquals(expectedReciept, actualReceipt);
    }
}
