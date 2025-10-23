package org.example.interviewquestions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequency{
    public static void main(String[] args){
        String str = "welcome to code decode and code decode welcome you all";
        final String[] strArrays = str.split(" ");

        final Map<String, Long> collect = Arrays.stream(strArrays).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect);



    }

}
