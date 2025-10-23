package org.example.interviewquestions;

import java.util.HashSet;
import java.util.Set;

public class FindFirstDuplicateChar{
    public static void main(String[] args){
        String str = "abbbdccaef";

        System.out.println("First duplicate character in \"" + str + "\": " + findFirstDuplicateChar(str));
    }

    private static Character findFirstDuplicateChar(String str){
        Set<Character> charSet = new HashSet<>();
        for(char c : str.toCharArray()){
            if(charSet.add(c) == false){
                return c; // First duplicate character found
            }
        }
        return null; // No duplicate character found
    }
}
