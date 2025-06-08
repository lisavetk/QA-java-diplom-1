package praktikum.unit;

import praktikum.Bun;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class TestData {
    public static final Bun TEST_BUN = new Bun("Bread", 2f);
    public static final Ingredient TEST_INGREDIENT_MEAT = new Ingredient(FILLING, "meat", 5f);
    public static final Ingredient TEST_INGREDIENT_TOMATO = new Ingredient(FILLING, "tomato", 1f);
    public static final Ingredient TEST_INGREDIENT_SAUCE = new Ingredient(SAUCE, "cheesy", 1.5f);

    public static final float EXPECTED_PRICE_ONLY_BUN = TEST_BUN.getPrice() * 2;
    public static final float EXPECTED_PRICE_BUN_MEAT_SAUCE = TEST_INGREDIENT_MEAT.getPrice() + TEST_INGREDIENT_SAUCE.getPrice() + TEST_BUN.getPrice() * 2;
    public static final float EXPECTED_PRICE_BUN_MEAT =  TEST_INGREDIENT_MEAT.getPrice() + TEST_BUN.getPrice() * 2;
    public static final float EXPECTED_PRICE_BUN_SAUCE = TEST_INGREDIENT_SAUCE.getPrice() + TEST_BUN.getPrice() * 2;


}
