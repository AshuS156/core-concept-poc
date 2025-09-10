package org.example.handson.premitivedatatype;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;

/*
  Question: WAP to find the Max/ the biggest Element
 */
public class FindMaxElement{
    public static void main(String[] args){
        int arr[] = {11,23,43,56,34,65,334,44};

        // Approach-1 with Aggregation method of Stream - Max()
        final OptionalInt maxElement = Arrays.stream(arr).max();
        System.out.println("Approach-1 with Aggregation Max () : "+ maxElement.getAsInt());

        //Approach-2 with Stream sorted method with Comparator.comparingInt and ifPresent method of Optional class
        Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(i -> (int) i).reversed())
                .findFirst().ifPresent(max -> System.out.println("Approach-2 with Stream sorted method with Comparator.comparingInt : " + max));


        //Approach-3 with Stream sorted method with Comparator.reversedOrder
        final Integer reverseOrder = Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("Approach-3 with Stream sorted method with Comparator.reversedOrder : "+ reverseOrder);



    }
}
