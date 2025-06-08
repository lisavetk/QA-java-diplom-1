package praktikum.unit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.unit.TestData.*;
import static praktikum.unit.TestsMessage.*;

@RunWith(Parameterized.class)
public class BurgerPriceParametersTest {

    private Burger burger;

    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final float expectedPrice;

    public BurgerPriceParametersTest(String testName, Bun bun, List<Ingredient> ingredients, float expectedPrice) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{index}: {0}, Expected price: {3}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Only Bun", TEST_BUN, List.of(), EXPECTED_PRICE_ONLY_BUN},
                {"Bun + meat + sauce", TEST_BUN, List.of(TEST_INGREDIENT_MEAT, TEST_INGREDIENT_SAUCE), EXPECTED_PRICE_BUN_MEAT_SAUCE}
        };
    }

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void shouldReturnPrice() {
        assertEquals(MESSAGE_WRONG_PRICE, expectedPrice, burger.getPrice(), 0.001f);
    }
}
