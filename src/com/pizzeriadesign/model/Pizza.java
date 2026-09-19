package com.pizzeriadesign.model;
import com.pizzeriadesign.factory.store.ingredient.Dough;
import com.pizzeriadesign.factory.store.ingredient.Cheese;
import com.pizzeriadesign.factory.store.ingredient.PizzaIngredientFactory;
//class defined like abstract because of part b, we need to different realization of method prepare()
public abstract class Pizza {
    String name;

    Dough dough;
    Cheese cheese;

    //part B
    public abstract void prepare();

    //part A
    //public void prepare(){
        //System.out.println("Preparing "+name);
    //}
    public void bake(){
        System.out.println("Baking "+name);
    }
    public void cut(){
        System.out.print("Cutting "+name);
    }
    public void box(){
        System.out.println("Packing "+name);
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
