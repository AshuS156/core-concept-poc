package org.example.handson.premitivedatatype;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
  Question: WAP to find the second Max/ the biggest Element
 */
public class FindSecondMaxElement{
    public static void main(String[] args){
        int arr[] = {22,11,23,98,56,34,65,334,44};
        final Integer secondLargeElement =Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println(secondLargeElement);


    }
}
