package org.example.generic;

import java.util.List;

public class GenericDemo{
    public static void main(String[] args){

        GenericDemo genericDemo = new GenericDemo();
        Integer i = 10;
        Float f = 5.5f;
        Double d = 15.99;
        genericDemo.dispay(i, f, d);
        genericDemo.dispay(10, 5, 15);
        final Integer hello = getData("Hello",100);
        final Class<String> world = getData("World",String.class);
        System.out.println(world);
        final String world1 = getData("World","");
        // write a method which accepts a generic type of all type integers, Float and sort in any order


    }

    public <T extends Number> void dispay(T firstinput ,T secondinput ,T thirdinput ){
        System.out.println("Sorting the inputs: " + firstinput + ", " + secondinput + ", " + thirdinput);
    }

    public static <T,R> R getData(T input,R returnType){
        return returnType;
    }


public void populate(List<? super Number> obj){

}
    public void populate(List<? super Number> obj, List<? extends Number> data){


    }

    public void populate(List<? super Number> obj,List<? extends Number> data,List<? super Number> data1){


    }
}
