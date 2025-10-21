package org.example.premitivedatatype;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/*
    Question: Find the longest string from a given string
 */
public class FindLongestStringFromAString{
    public static void main(String[] args){
        String str = "hi ashu how are you doing today";

        final Optional<String> matchFound = Arrays.stream(str.split(" ")).sorted(Comparator.comparing(String::length).reversed())
                .findFirst();
        if (matchFound.isPresent()) {
            System.out.println("Longest string in the given string is: " + matchFound.get());
        } else {
            System.out.println("No match found");
        }

    }
}
