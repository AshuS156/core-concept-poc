package org.example.programs;

import java.util.Arrays;

public class AnagramCheck2{

    public static void main(String[] args){
        String str1 = "triangle";
        String str2 = "integral";

        if(str1.length() != str2.length()){
            System.out.println("Not anagrams");
            return;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        if(Arrays.equals(charArray1, charArray2)){
            System.out.println("Anagrams");
        } else {
            System.out.println("Not anagrams");
        }
    }
}
