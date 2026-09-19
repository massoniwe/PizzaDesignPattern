package com.pizzeriadesign;

import com.pizzeriadesign.factory.store.PizzaStore;
import com.pizzeriadesign.factory.store.SimplePizzaStore;
import com.pizzeriadesign.model.Pizza;

public class Main{

    public static void main(String[] args){

        PizzaStore store = new SimplePizzaStore();

        System.out.println("Making cheese order");
        Pizza pizza=store.orderPizza("cheese");
        System.out.println("Result is "+pizza.getName()+"\n");

        System.out.println("Making pepperoni order");
        Pizza pizza2=store.orderPizza("pepperoni");
        System.out.println("Result is "+pizza2.getName()+"\n");
    }
}
