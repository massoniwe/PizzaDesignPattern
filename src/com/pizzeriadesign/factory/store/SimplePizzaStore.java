package com.pizzeriadesign.factory.store;

import com.pizzeriadesign.factory.store.ingredient.NYPizzaIngredientFactory;
import com.pizzeriadesign.factory.store.ingredient.PizzaIngredientFactory;
import com.pizzeriadesign.model.CheesePizza;
import com.pizzeriadesign.model.PepperoniPizza;
import com.pizzeriadesign.model.Pizza;

public class SimplePizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String type){
        Pizza pizza=null;

        PizzaIngredientFactory ingredientFactory=new NYPizzaIngredientFactory();

        if(type.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York cheese pizza");
        }
        else if(type.equals("pepperoni")) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Pepperoni");
        }
        return pizza;
    }
}
