import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientGetTypeParameterizedTest {
    public Ingredient ingredient;
    public IngredientType type;

    public IngredientGetTypeParameterizedTest(Ingredient ingredient, IngredientType expectedType) {
        this.ingredient = ingredient;
        this.type = expectedType;
    }

    @Parameterized.Parameters(name = "Test data: {0}, {1}")
    public static Collection ingredients() {
        return Arrays.asList(new Object[][] {
                { new Ingredient(IngredientType.SAUCE, "sour cream", 100), SAUCE},
                { new Ingredient(IngredientType.FILLING, "cutlet", 100), FILLING}
        });
    }

    @Test
    //Check IngredientType getType method returns correct ingredient type
    public void checkGetTypeReturnsCorrectIngredientType(){
        Ingredient newIngredient = ingredient;

        IngredientType expectedType = type;
        IngredientType actualType = newIngredient.getType();

        assertEquals(expectedType, actualType);
    }
}
