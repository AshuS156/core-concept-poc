package org.example.interviewquestions;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindNonDuplicateElement{
    public static void main(String[] args){
        String str = "swiss";

        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity() , Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .forEach(System.out::println);
    }
}
