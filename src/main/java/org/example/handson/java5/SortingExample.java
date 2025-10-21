package org.example.handson.java5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingExample{

    public static void main(String[] args){

        List<String> names = Arrays.asList("John","Alice","Bob","Charlie");



        Collections.sort(names , (s1,s2) ->  {

            return  s1.length() - s2.length();
        } );

        System.out.println("Sorted names by length using lambda: " + names);
        Collections.sort(names,new Comparator<String>(){
            @Override
            public int compare(String o1,String o2){
                return o1.length() - o2.length();
            }
        });

        System.out.println("Sorted names by length: " + names);
    }
}
