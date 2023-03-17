package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING},
        });
    }

    private final String from;
    private final IngredientType ingredientType;

    public IngredientTypeTest(String from, IngredientType ingredientType) {
        this.from = from;
        this.ingredientType = ingredientType;
    }

    @Test
    public void ingredientTypeTest() {
        assertThat(IngredientType.valueOf(from))
                .isEqualTo(ingredientType);
    }
}