package org.example.programs;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Frequency{
    public static void main(String[] args){

        String s = "Raining here";
        final Map<Character, Long> collect = s.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect);

        String str = "hello world Java programming";

        final Map<String, Long> frequencyMap = str.split(" ") != null ?
               Arrays.stream(str.split(" "))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                : java.util.Collections.emptyMap();
        System.out.println(frequencyMap);



    }

}
