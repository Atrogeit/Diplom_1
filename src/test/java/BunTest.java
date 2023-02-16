import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test data: Name, Price")
    public static Object[][] bunTestSet() {
        return new Object[][] {
                {"ok name", 100.00f},
                {"", 1.1e-38f},
                {null, 1.7e38f},
                {"!@#$%^&*()_+", 100.00f},
                {"white bun", 0.0f},
                {"red bun", 1.02f/2.0f},
                {"black bun", -100.0f},
                {"Test name is tooooooooo loooooong whatever this name is", 3.1415926535f},
        };
    }

    @Test
    //Check for GetName method to return correct name
    public void checkGetNameReturnsCorrectName() {
        Bun bun = new Bun(name, price);

        assertEquals(name, bun.getName());
    }

    @Test
    //Check for GetPrice method to return correct price
    public void checkGetPriceReturnsCorrectPrice() {
        Bun bun = new Bun(name, price);

        assertEquals(price, bun.getPrice(), 0.0);
    }
}
