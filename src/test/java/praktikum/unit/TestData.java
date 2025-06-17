package praktikum.unit;

public class TestData {
    public static final float PRICE_TEST_BUN = 2f;
    public static final float PRICE_TEST_INGREDIENT_TOMATO = 1f;
    public static final float PRICE_TEST_INGREDIENT_MEAT = 5f;
    public static final float PRICE_TEST_INGREDIENT_SAUCE = 1.5f;

    public static final float EXPECTED_PRICE_ONLY_BUN = PRICE_TEST_BUN * 2;
    public static final float EXPECTED_PRICE_BUN_MEAT_SAUCE = PRICE_TEST_INGREDIENT_MEAT + PRICE_TEST_INGREDIENT_SAUCE + PRICE_TEST_BUN * 2;
    public static final float EXPECTED_PRICE_BUN_MEAT =  PRICE_TEST_INGREDIENT_MEAT + PRICE_TEST_BUN * 2;
    public static final float EXPECTED_PRICE_BUN_SAUCE = PRICE_TEST_INGREDIENT_SAUCE + PRICE_TEST_BUN * 2;
}
