import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    //Check for getName method to return correct ingredient name
    public void checkGetNameReturnsCorrectIngredientName(){

        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);

        String expectedName = "dinosaur";
        String actualName = ingredient.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    //Check for getPrice method to return correct price for ingredient
    public void checkGetPriceReturnsCorrectIngredientPrice() {

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

        float expectedPrice = 100;
        float actualPrice = ingredient.getPrice();

        assertEquals(expectedPrice, actualPrice,  0.0f);
    }


}