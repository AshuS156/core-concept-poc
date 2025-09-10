package org.example.handson.premitivedatatype;

/*
Question: Find all duplicate / repeatable characters from a string
 */

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateCharFromAString{
    public static void main(String[] args){

        String str = "hi , how are you doing today ?";


        // Approach 1: Using Collectors.groupingBy and Collectors.counting
        final Map<String, Long> collect = Arrays.stream(str.trim().split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Duplicate characters with count: " + collect);
           collect.entrySet().stream().filter(entry -> entry.getValue() >1)
                .forEach(entry -> System.out.println("Duplicate Key : " + entry.getKey() + "Count : "+ entry.getValue()));

        // Approach 2: Using Collectors.groupingBy and filtering
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("Duplicate word: " + entry.getKey() + " Count: " + entry.getValue()));

        // Approach 1.2.1:
        Map<String, Long> duplicateChars = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("duplicateChars: " + duplicateChars);

        // Approach 3: Removed space from string and then find duplicates
        String joinedString = Arrays.stream(str.split(" ")).collect(Collectors.joining());
        System.out.println("Joined string: " + joinedString);
        Map<String, Long> duplicateCharsWithoutSpace = Arrays.stream(joinedString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Duplicate characters without space: " + duplicateCharsWithoutSpace);



    }
}
