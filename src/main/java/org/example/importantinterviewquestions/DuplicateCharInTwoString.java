package org.example.importantinterviewquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateCharInTwoString{
    public static void main(String[] args){
        String str1 = "apple";
        String str2 = "grape";

        System.out.println("Duplicate characters between \"" + str1 + "\" and \"" + str2 + "\":");
        findDuplicateCharacters(str1, str2);
        findDuplicateCharacterswithContains(str1, str2);
        findDuplicateCharacterswithRetainAll();
    }

    private static void findDuplicateCharacterswithContains(String str1,String str2){
        System.out.println("\nUsing Contains method:");
        Arrays.asList(str1.split("")).stream()
                .filter(c -> str2.contains(c))
                .forEach(c -> System.out.print(c + " "));

    }

    private static void findDuplicateCharacterswithRetainAll(){

        System.out.println("\nUsing RetainAll method:");

        final List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        final List<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");
        list2.add("d");


        list1.retainAll(list2);
        System.out.println(list1);

    }


    private static void findDuplicateCharacters(String str1,String str2){
        final char[] charArray = str1.toCharArray();
        System.out.println(charArray);

        for(char c : str1.toCharArray()){
           // System.out.println("c : " + c +  ", str2.indexOf(c) " + str2.indexOf(c));
            // check if character is present in second string
            if(str2.indexOf(c) != -1){
              System.out.print(c + " ");
            }
        }
    }
}
