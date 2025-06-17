package praktikum.unit;

import org.junit.Before;
import org.junit.Test;
import praktikum.Burger;
import org.assertj.core.api.SoftAssertions;

import static org.junit.Assert.*;
import static praktikum.unit.TestsMessage.*;
import static praktikum.unit.TestData.*;

public class BurgerTest {

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void shouldSetBun() {
        burger.setBuns(TEST_BUN);
        assertEquals(MESSAGE_BUN_NOT_MATCH, TEST_BUN, burger.bun);

    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(TEST_INGREDIENT_MEAT);
        assertEquals(MESSAGE_INGREDIENT_NOT_MATCH, TEST_INGREDIENT_MEAT, burger.ingredients.get(0));
    }

    @Test
    public void shouldAddSameIngredients() {
        burger.addIngredient(TEST_INGREDIENT_MEAT);
        burger.addIngredient(TEST_INGREDIENT_MEAT);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(burger.ingredients.get(0)).as(MESSAGE_INGREDIENT_NOT_MATCH).isEqualTo(TEST_INGREDIENT_MEAT);
        softAssertions.assertThat(burger.ingredients.get(1)).as(MESSAGE_INGREDIENT_NOT_MATCH).isEqualTo(TEST_INGREDIENT_MEAT);
        softAssertions.assertThat(burger.ingredients.size())
                .as(MESSAGE_COUNT_INGREDIENTS_NOT_MATCH)
                .isEqualTo(2);

    }

    @Test
    public void shouldRemoveIngredient() {
        burger.addIngredient(TEST_INGREDIENT_MEAT);

        burger.removeIngredient(0);
        assertEquals(MESSAGE_INGREDIENT_NOT_DELETE, 0, burger.ingredients.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenRemovingIngredientWithInvalidIndex() {
        burger.removeIngredient(0);
    }

    @Test
    public void shouldMoveIngredientToNewPosition() {
        burger.addIngredient(TEST_INGREDIENT_MEAT);
        burger.addIngredient(TEST_INGREDIENT_TOMATO);
        burger.addIngredient(TEST_INGREDIENT_SAUCE);

        burger.moveIngredient(1, 0);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(burger.ingredients.get(0)).as(MESSAGE_INGREDIENT_NOT_MOVE).isEqualTo(TEST_INGREDIENT_TOMATO);
        softAssertions.assertThat(burger.ingredients.get(1)).as(MESSAGE_INGREDIENT_FROM_NEW_POSITION).isEqualTo(TEST_INGREDIENT_MEAT);
        softAssertions.assertThat(burger.ingredients.get(2)).as(MESSAGE_INGREDIENT_NOT_AFFECTED_MOVE).isEqualTo(TEST_INGREDIENT_SAUCE);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMovingIngredientFromInvalidIndex() {
        burger.moveIngredient(1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMovingIngredientToInvalidIndex() {
        burger.addIngredient(TEST_INGREDIENT_MEAT);

        burger.moveIngredient(0, 1);
    }

    @Test
    public void shouldNotChangeIngredientWhenMovingToSamePosition() {
        burger.addIngredient(TEST_INGREDIENT_MEAT);

        burger.moveIngredient(0, 0);
        assertEquals(MESSAGE_INGREDIENT_SHOULD_STAY, TEST_INGREDIENT_MEAT, burger.ingredients.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnPriceWithoutBun() {
        burger.addIngredient(TEST_INGREDIENT_MEAT);
        burger.addIngredient(TEST_INGREDIENT_SAUCE);

        burger.getPrice();
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnReceiptWithoutBunAndIngredient() {
        burger.getReceipt();
    }

}
