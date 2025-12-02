package org.example.singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test{
    public static void main(String[] args){
        List<String> list = Arrays.asList("A", "B", "C");
        Singleton singleton = Singleton.getInstance(list);
        System.out.println("Singleton instance created: " + singleton);
        System.out.println(singleton.getAl());
        List<String> al2 = singleton.getAl();
        al2.add("D");
        al2.add("E");
        System.out.println(singleton.getAl());



    }
}
