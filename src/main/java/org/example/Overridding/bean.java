package org.example.Overridding;

public class bean{
    public static void main(String[] args){
       A obj = new B();
       obj.display();
       System.out.println(obj.x);
    }
}
