package com.pizzeriadesign.factory.store.ingredient;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public Dough createDough(){
        return new ThinCrustDough();
    }

    @Override
    public Cheese createCheese(){
        return new MozzarellaCheese();
    }
}
