package com.pizzeriadesign.model;

public class Pizza {
    String name;
    public void prepare(){
        System.out.println("Preparing "+name);
    }
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
}
