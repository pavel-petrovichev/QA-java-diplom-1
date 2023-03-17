package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DatabaseTest {

    Database database;

    @Before
    public void createDatabase() {
        database = new Database();
    }

    @Test
    public void availableBuns() {
        assertThat(database.availableBuns())
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(List.of(
                        new Bun("black bun", 100),
                        new Bun("white bun", 200),
                        new Bun("red bun", 300)));
    }

    @Test
    public void availableIngredients() {
        assertThat(database.availableIngredients())
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(List.of(
                        new Ingredient(IngredientType.SAUCE, "hot sauce", 100),
                        new Ingredient(IngredientType.SAUCE, "sour cream", 200),
                        new Ingredient(IngredientType.SAUCE, "chili sauce", 300),
                        new Ingredient(IngredientType.FILLING, "cutlet", 100),
                        new Ingredient(IngredientType.FILLING, "dinosaur", 200),
                        new Ingredient(IngredientType.FILLING, "sausage", 300)));
    }
}