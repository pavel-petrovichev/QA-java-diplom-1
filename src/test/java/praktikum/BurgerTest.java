package praktikum;

import org.assertj.core.data.Offset;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BurgerTest {

    Burger burger;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void price() {
        burger.setBuns(new Bun("white bun", 50.0f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 5.0f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 75f));

        float price = burger.getPrice();

        assertThat(price).isCloseTo(180.0f, Offset.offset(1E-9f));
    }

    @Test
    public void receipt() {
        burger.setBuns(new Bun("white bun", 50.0f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 5.0f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 75f));

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
        burger.setBuns(new Bun("white bun", 50.0f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 5.0f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 75f));

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
        burger.setBuns(new Bun("white bun", 50.0f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 5.0f));
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "sausage", 75f));

        burger.removeIngredient(0);

        assertThat(burger.getReceipt()).isEqualTo("" +
                "(==== white bun ====)\r\n" +
                "= filling sausage =\r\n" +
                "(==== white bun ====)\r\n" +
                "\r\n" +
                "Price: 175,000000\r\n");
    }
}