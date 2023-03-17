package praktikum;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BunTest {

    @Test
    public void getName() {
        Bun bun = new Bun("white bun", 123f);
        assertThat(bun.getName()).isEqualTo("white bun");
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun("white bun", 123f);
        assertThat(bun.getPrice()).isEqualTo(123f, Offset.offset(1e-12f));
    }
}