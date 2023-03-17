package praktikum;

import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class BurgerTest {

    Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void price() {
        burger.setBuns(bun("white bun", 50.0f));
        burger.addIngredient(ingredient(IngredientType.SAUCE, "hot sauce", 5.0f));
        burger.addIngredient(ingredient(IngredientType.FILLING, "sausage", 75f));

        float price = burger.getPrice();

        assertThat(price).isCloseTo(180.0f, Offset.offset(1E-9f));
    }

    @Test
    public void receipt() {
        burger.setBuns(bun("white bun", 50.0f));
        burger.addIngredient(ingredient(IngredientType.SAUCE, "hot sauce", 5.0f));
        burger.addIngredient(ingredient(IngredientType.FILLING, "sausage", 75f));

        assertThat(burger.getReceipt()).isEqualTo("" +
                "(==== white bun ====)\r\n" +
                "= sauce hot sauce =\r\n" +
                "= filling sausage =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 180,000000\r\n");
    }

    @Test
    public void moveIngredient() {
        burger.setBuns(bun("white bun", 50.0f));
        burger.addIngredient(ingredient(IngredientType.SAUCE, "hot sauce", 5.0f));
        burger.addIngredient(ingredient(IngredientType.FILLING, "sausage", 75f));

        burger.moveIngredient(0, 1);

        assertThat(burger.getReceipt()).isEqualTo("" +
                "(==== white bun ====)\r\n" +
                "= filling sausage =\r\n" +
                "= sauce hot sauce =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 180,000000\r\n");
    }

    @Test
    public void removeIngredient() {
        burger.setBuns(bun("white bun", 50.0f));
        burger.addIngredient(ingredient(IngredientType.SAUCE, "hot sauce", 5.0f));
        burger.addIngredient(ingredient(IngredientType.FILLING, "sausage", 75f));

        burger.removeIngredient(0);

        assertThat(burger.getReceipt()).isEqualTo("" +
                "(==== white bun ====)\r\n" +
                "= filling sausage =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 175,000000\r\n");
    }

    private Bun bun(String name, float price) {
        Bun bun = Mockito.mock(Bun.class);
        Mockito.when(bun.getName()).thenReturn(name);
        Mockito.when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    private Ingredient ingredient(IngredientType ingredientType, String name, float price) {
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(name);
        Mockito.when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }
}