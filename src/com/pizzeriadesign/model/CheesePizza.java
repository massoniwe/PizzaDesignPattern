package com.pizzeriadesign.model;
import com.pizzeriadesign.factory.store.ingredient.PizzaIngredientFactory;

public class CheesePizza extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare(){
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        cheese = ingredientFactory.createCheese();
        System.out.println("Tossing " + dough.getName());
        System.out.println("Adding " + cheese.getName());
    }
}
