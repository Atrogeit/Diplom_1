import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Spy
    Ingredient ingredient = new Ingredient(SAUCE, "chili sauce", 300);

    @Test
    //Checking AddIngredients method to add the ingredients
    public void checkAddIngredientsAddsTheIngredientsIntoIngredientList() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "chili sauce", 300);

        int expectedSizeListIngredient = 1;
        burger.addIngredient(ingredient);

        assertEquals(expectedSizeListIngredient, burger.ingredients.size());

    }

    @Test
    //Checking removeIngredient method to remove the ingredients
    public void checkRemoveIngredientToRemoveIngredientsFromIngredientList() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(SAUCE, "chili sauce", 300);

        burger.ingredients.add(ingredient);
        int expectedSizeListIngredient = 0;
        burger.removeIngredient(0);

        assertEquals(expectedSizeListIngredient, burger.ingredients.size());
    }

    @Test
    //Checking SetBuns method to set the Bun for Burger
    public void checkSetBunsToSetBun() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("white bun", 200));

        String expectedBunName = "white bun";
        float expectedBunPrice = 200;
        String actualBunName = burger.bun.name;
        float actualBunPrice = burger.bun.price;

        assertEquals(expectedBunName, actualBunName);
        assertEquals(expectedBunPrice, actualBunPrice, 0.0f);
    }

    @Test
    //Checking GetPrice method to return correct price of burger with ingredients
    public void checkGetPriceReturnsCorrectBurgerWithIngredientsPrice(){

        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.ingredients.add(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(300.00F);
        Mockito.when(ingredient.getPrice()).thenReturn(250.00F);

        float expectedTotalPrice = 850.0F;
        float actualTotalPrice = burger.getPrice();

        assertEquals(expectedTotalPrice, actualTotalPrice, 0.0f);
    }

    @Test
    //Checking GetReceipt returns the receipt with ingredients and price
    public void checkGetReceiptReturnsReceipt(){

        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.ingredients.add(ingredient);

        //Changing ingredients from those in database
        Mockito.when(bun.getName()).thenReturn("onion bun");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("bbq sauce");
        Mockito.when(burger.getPrice()).thenReturn(100500.00F);

        String expectedReceipt = "(==== onion bun ====)\n= sauce bbq sauce =\n(==== onion bun ====)\n\nPrice: 100500.000000\n";
        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test
    //Check moveIngredients method to change the ingredients positions
    public void checkMoveIngredientToChangeIngredientPosition(){

        Burger burger = new Burger();
        Ingredient ingredientFilling = new Ingredient(FILLING, "dinosaur", 100);
        Ingredient ingredientSauce = new Ingredient(SAUCE, "chili sauce", 300);

        burger.ingredients.add(ingredientFilling);
        burger.ingredients.add(ingredientSauce);

        IngredientType expectedIngredientType = FILLING;
        IngredientType actualIngredientType = burger.ingredients.get(0).type;

        String expectedIngredientName = "chili sauce";
        String actualIngredientName = burger.ingredients.get(1).name;

        float expectedPrice = 300;
        float actualPrice = burger.ingredients.get(1).price;

        burger.moveIngredient(0, 1);


        assertEquals(expectedIngredientType, actualIngredientType);
        assertEquals(expectedIngredientName, actualIngredientName);
        assertEquals(expectedPrice, actualPrice, 0.0f);
    }

}