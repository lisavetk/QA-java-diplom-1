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
import static praktikum.unit.TestMocks.*;
import static praktikum.unit.TestsMessage.*;

@RunWith(Parameterized.class)
public class BurgerReceiptTest {

    private Burger burger;

    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expectedReceipt;


    public BurgerReceiptTest(String testName, Bun bun, List<Ingredient> ingredients, String expectedReceipt) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedReceipt = expectedReceipt;
    }

    private static String createReceipt(Bun bun, List<Ingredient> ingredients, float price) {
        StringBuilder receipt = new StringBuilder();
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        for (Ingredient ingredient : ingredients) {
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", price));
        return receipt.toString();

    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Only Bun", getMockBun(), List.of(), createReceipt(getMockBun(), List.of(), EXPECTED_PRICE_ONLY_BUN)},
                {"Bun + meat + sauce", getMockBun(), List.of(getMockMeat(), getMockSauce()),
                        createReceipt(getMockBun(), List.of(getMockMeat(), getMockSauce()), EXPECTED_PRICE_BUN_MEAT_SAUCE)},
                {"Bun + meat", getMockBun(), List.of(getMockMeat()),
                        createReceipt(getMockBun(), List.of(getMockMeat()), EXPECTED_PRICE_BUN_MEAT)},
                {"Bun + sauce", getMockBun(), List.of(getMockSauce()),
                        createReceipt(getMockBun(), List.of(getMockSauce()), EXPECTED_PRICE_BUN_SAUCE)},
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
    public void shouldReturnReceipt() {
        assertEquals(MESSAGE_WRONG_RECEIPT, expectedReceipt, burger.getReceipt());
    }
}
