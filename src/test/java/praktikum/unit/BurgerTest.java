package praktikum.unit;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import org.assertj.core.api.SoftAssertions;
import praktikum.Ingredient;

import static org.junit.Assert.*;
import static praktikum.unit.TestMocks.*;
import static praktikum.unit.TestsMessage.*;

public class BurgerTest {

    private Burger burger;

    private Bun mockBun;
    private Ingredient mockIngredientMeat;
    private Ingredient mockIngredientTomato;
    private Ingredient mockIngredientSauce;


    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = getMockBun();
        mockIngredientMeat = getMockMeat();
        mockIngredientTomato = getMockTomato();
        mockIngredientSauce = getMockSauce();
    }

    @Test
    public void shouldSetBun() {
        burger.setBuns(mockBun);
        assertEquals(MESSAGE_BUN_NOT_MATCH, mockBun, burger.bun);

    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(mockIngredientMeat);
        assertEquals(MESSAGE_INGREDIENT_NOT_MATCH, mockIngredientMeat, burger.ingredients.get(0));
    }

    @Test
    public void shouldAddSameIngredients() {
        burger.addIngredient(mockIngredientMeat);
        burger.addIngredient(mockIngredientMeat);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(burger.ingredients.get(0)).as(MESSAGE_INGREDIENT_NOT_MATCH).isEqualTo(mockIngredientMeat);
        softAssertions.assertThat(burger.ingredients.get(1)).as(MESSAGE_INGREDIENT_NOT_MATCH).isEqualTo(mockIngredientMeat);
        softAssertions.assertThat(burger.ingredients.size())
                .as(MESSAGE_COUNT_INGREDIENTS_NOT_MATCH)
                .isEqualTo(2);
        softAssertions.assertAll();
    }

    @Test
    public void shouldRemoveIngredient() {
        burger.addIngredient(mockIngredientMeat);

        burger.removeIngredient(0);
        assertEquals(MESSAGE_INGREDIENT_NOT_DELETE, 0, burger.ingredients.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenRemovingIngredientWithInvalidIndex() {
        burger.removeIngredient(0);
    }

    @Test
    public void shouldMoveIngredientToNewPosition() {
        burger.addIngredient(mockIngredientMeat);
        burger.addIngredient(mockIngredientTomato);
        burger.addIngredient(mockIngredientSauce);

        burger.moveIngredient(1, 0);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(burger.ingredients.get(0)).as(MESSAGE_INGREDIENT_NOT_MOVE).isEqualTo(mockIngredientTomato);
        softAssertions.assertThat(burger.ingredients.get(1)).as(MESSAGE_INGREDIENT_FROM_NEW_POSITION).isEqualTo(mockIngredientMeat);
        softAssertions.assertThat(burger.ingredients.get(2)).as(MESSAGE_INGREDIENT_NOT_AFFECTED_MOVE).isEqualTo(mockIngredientSauce);
        softAssertions.assertAll();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMovingIngredientFromInvalidIndex() {
        burger.moveIngredient(1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMovingIngredientToInvalidIndex() {
        burger.addIngredient(mockIngredientMeat);

        burger.moveIngredient(0, 1);
    }

    @Test
    public void shouldNotChangeIngredientWhenMovingToSamePosition() {
        burger.addIngredient(mockIngredientMeat);

        burger.moveIngredient(0, 0);
        assertEquals(MESSAGE_INGREDIENT_SHOULD_STAY, mockIngredientMeat, burger.ingredients.get(0));
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnPriceWithoutBun() {
        burger.addIngredient(mockIngredientMeat);
        burger.addIngredient(mockIngredientSauce);

        burger.getPrice();
    }

    @Test(expected = NullPointerException.class)
    public void shouldReturnReceiptWithoutBunAndIngredient() {
        burger.getReceipt();
    }

}
