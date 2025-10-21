package org.example.premitivedatatype;

/*
Question: Find all duplicate / repeatable characters from a string
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateCharFromAString{
    public static void main(String[] args){

        String str = "hi , how are you doing today ?";

        // Approach 1: Using Set and filter to find duplicates
        Set<String> charSet = new HashSet<>();
        final String stringWithoutSpace = Arrays.stream(str.split(" ")).collect(Collectors.joining());
        System.out.println("String without space: " + stringWithoutSpace);
        final List<String> dupdata = Arrays.stream(stringWithoutSpace.split("")).filter(s -> !charSet.add(s)).collect(Collectors.toList());
        System.out.println("Duplicate characters using Set: " + dupdata);


        // Approach 2: Using Collectors.groupingBy and Collectors.counting
        final Map<String, Long> collect = Arrays.stream(stringWithoutSpace.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("Using Collectors.groupingBy and Collectors.counting " + collect);
           collect.entrySet().stream().filter(entry -> entry.getValue() >1)
                .forEach(entry -> System.out.println("Duplicate Key : " + entry.getKey() + "Count : "+ entry.getValue()));

        // Approach 2.1: Using Collectors.groupingBy and filtering
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("Duplicate word: " + entry.getKey() + " Count: " + entry.getValue()));

        // Approach 2.2:
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

        // Approach 4: Using LinkedHashMap to maintain insertion order
        String query = "dockerandzookeeper";
        LinkedHashMap<String, Long> linkedHashMap = Arrays.stream(query.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("LinkedHashMap with insertion order: " + linkedHashMap);
    }
}
