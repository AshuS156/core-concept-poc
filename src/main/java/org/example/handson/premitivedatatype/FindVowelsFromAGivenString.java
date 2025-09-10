package org.example.handson.premitivedatatype;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
   Question: WAP to find all FindVowelsFromAGivenString
 */
public class FindVowelsFromAGivenString{
    public static void main(String[] args){
        String query = "I am a big fan of Java and i Love Java";
        final List<Character> listOfVowels = query.chars().mapToObj(c -> (char) c)
                .filter(ch -> "AEIOUaeiou".contains(ch.toString())).collect(Collectors.toList());
        System.out.println("Approach-1 : " +listOfVowels);

        final List<Character> listOfVowels2 = query.chars().mapToObj(c -> (char) c)
                .filter(ch -> "AEIOUaeiou".contains(String.valueOf(ch))).collect(Collectors.toList());
        System.out.println("Approach-2 : " + listOfVowels2);
    }
}
