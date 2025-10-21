package org.example.methodrefrence;

//@FunctionalInterface
public interface Payment{

   // void pay(int amount);

    public static void show(){
        System.out.println("Static method in interface");
    }

    public default void display(){
        System.out.println("Default method in interface");
    }


}
