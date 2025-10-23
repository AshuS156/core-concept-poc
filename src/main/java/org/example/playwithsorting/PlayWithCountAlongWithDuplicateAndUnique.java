package org.example.playwithsorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PlayWithCountAlongWithDuplicateAndUnique{
    public static void main(String[] args){

        // Count of a specific character in a string
        String str = "hi , how are you doing today ?";
        long count = str.chars().filter(ch -> ch == 'o').count();
        System.out.println("Count of character 'o': " + count);

        String str2 = "hello world";
        Set hs = new HashSet<>();
        final List<Character> collect = str2.chars().mapToObj(ch -> (char) ch).
                filter(ob -> !hs.add(ob)).collect(Collectors.toList());
        System.out.println("Duplicate characters in 'hello world': " + collect);
    }
}
