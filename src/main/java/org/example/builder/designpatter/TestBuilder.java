package org.example.builder.designpatter;

public class TestBuilder{
    public static void main(String[] args){
        final Mobile mobile = new Mobile.Builder().setName("I-Phone").buildMobileObject();
        System.out.println(mobile);

    }
}
