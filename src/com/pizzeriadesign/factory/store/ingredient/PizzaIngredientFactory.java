package com.pizzeriadesign.factory.store.ingredient;

public interface PizzaIngredientFactory {
    Dough createDough();
    Cheese createCheese();
}
