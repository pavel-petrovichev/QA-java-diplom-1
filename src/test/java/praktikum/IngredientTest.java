package praktikum;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientTest {

    @Test
    public void getPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 5.0f);
        assertThat(ingredient.getPrice()).isEqualTo(5.0f, Offset.offset(1e-12f));
    }

    @Test
    public void getName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 5.0f);
        assertThat(ingredient.getName()).isEqualTo("hot sauce");
    }

    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 5.0f);
        assertThat(ingredient.getType()).isEqualTo(IngredientType.SAUCE);
    }
}