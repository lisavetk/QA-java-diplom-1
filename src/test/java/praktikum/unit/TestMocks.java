package praktikum.unit;

import praktikum.Bun;
import praktikum.Ingredient;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static praktikum.unit.TestData.*;

public class TestMocks {
    public static Bun getMockBun() {
        Bun mockBun = mock(Bun.class);
        when(mockBun.getPrice()).thenReturn(PRICE_TEST_BUN);
        when(mockBun.getName()).thenReturn("Bread");
        return mockBun;
    }

    public static Ingredient getMockMeat() {
        Ingredient mockIngredientMeat = mock(Ingredient.class);
        when(mockIngredientMeat.getPrice()).thenReturn(PRICE_TEST_INGREDIENT_MEAT);
        when(mockIngredientMeat.getName()).thenReturn("meat");
        when(mockIngredientMeat.getType()).thenReturn(praktikum.IngredientType.FILLING);
        return mockIngredientMeat;
    }

    public static Ingredient getMockTomato() {
        Ingredient mockIngredientTomato = mock(Ingredient.class);
        when(mockIngredientTomato.getPrice()).thenReturn(PRICE_TEST_INGREDIENT_TOMATO);
        when(mockIngredientTomato.getName()).thenReturn("tomato");
        when(mockIngredientTomato.getType()).thenReturn(praktikum.IngredientType.FILLING);
        return mockIngredientTomato;
    }

    public static Ingredient getMockSauce() {
        Ingredient mockIngredientSauce = mock(Ingredient.class);
        when(mockIngredientSauce.getPrice()).thenReturn(PRICE_TEST_INGREDIENT_SAUCE);
        when(mockIngredientSauce.getName()).thenReturn("cheesy");
        when(mockIngredientSauce.getType()).thenReturn(praktikum.IngredientType.SAUCE);
        return mockIngredientSauce;
    }
}
