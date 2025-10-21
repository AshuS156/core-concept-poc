package org.example.premitivedatatype;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*

Question : Find the first non-repeating character in a string

 */
public class FindFirstNonRepeatingChar{
    public static void main(String[] args){
        String query = "zookeeperanddocker";

        // Approach 1: Using Collectors.groupingBy , LinkedHashMap, findFirst and Collectors.counting
        final LinkedHashMap<String, Long> collect = Arrays.stream(query.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        collect.entrySet().stream().filter(entry -> entry.getValue() == 1)
                .findFirst()
                .ifPresent(entry -> System.out.println("First non-repeating character: " + entry.getKey()));



        // Approach 2: Using Collectors.groupingBy ,LinkedHashMap, skip and filtering
        final LinkedHashMap<String, Long> collect2 = Arrays.stream(query.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));

        final List<String> firstNonRepeatingChar = collect2.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .limit(1)
                .collect(Collectors.toList());
        System.out.println("LinkedHashMap with character counts: " + firstNonRepeatingChar);
    }
}
