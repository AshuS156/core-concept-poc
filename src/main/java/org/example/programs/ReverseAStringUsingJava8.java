package org.example.programs;

import java.util.Arrays;

public class ReverseAStringUsingJava8{
    public static void main(String[] args){
        // revered a string using java 8 stream
        String input= "i am learning java8 stream api";
        final String reversedString = Arrays.stream(input.split(" "))
                .reduce((a, b) -> b + " " + a).get();
        System.out.println(reversedString);
    }
}
