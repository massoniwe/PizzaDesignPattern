package com.pizzeriadesign.factory.store;

import com.pizzeriadesign.model.Pizza;
import com.pizzeriadesign.model.PepperoniPizza;
import com.pizzeriadesign.model.CheesePizza;

public class SimplePizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type){
        if(type.equals("cheese")){
            return new CheesePizza();
        }
        else if(type.equals("pepperoni")){
            return new PepperoniPizza();
        }
        else{
            return null;
        }
    }
}
