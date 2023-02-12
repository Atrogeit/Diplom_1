import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    //Check for GetName method  to return correct name
    public void checkGetNameReturnsCorrectName() {

        Bun bun = new Bun("red bun", 300);

        String expected = "red bun";
        String actual = bun.getName();

        assertEquals(expected, actual);
    }

    @Test
    //Check for GetPrice method to return correct price
    public void checkGetPriceReturnsCorrectPrice() {

        Bun bun = new Bun("white bun", 200);

        float expected = 200;
        float actual = bun.getPrice();

        assertEquals(expected, actual, 0.0f);
    }


}