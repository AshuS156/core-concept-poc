package org.example.methodrefrence;

public class PaymentImpl implements Payment{

    PaymentImpl(){
        System.out.println("PaymentImpl constructor called");
    }

    public void pay(int amount){
        System.out.println("Paid amount: " + amount);
    }

    public static void show(){
        System.out.println("Static method in PaymentImpl class");
    }



}
