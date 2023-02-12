import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientContainsTypeTest {

    @Test
    //Check for Ingredient class contains data (Sauce and Filling)
    public void checkIngredientTypeContainsCorrectData() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
