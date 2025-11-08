package org.example.importantinterviewquestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.OptionalInt;

public class SortStringBasedOnLeangth{
    public static void main(String[] args){
        String input= "i am a java developer and i love programming";
        final String s = Arrays.stream(input.split(" ")).sorted(Comparator.comparing(String::length).reversed()).findFirst().get();
        System.out.println(s);




    }
}
