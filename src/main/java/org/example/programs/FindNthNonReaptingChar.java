package org.example.programs;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindNthNonReaptingChar {

    public static void main(String[] args) {
        String st = "There is a tree tree has a leaves and leaves are green in color";
        final char nthNonReaptingChar = findNthNonReaptingChar(st, 3);
        System.out.println(nthNonReaptingChar);
        findNthNonReaptingCharWithStream(st, 1);
    }

    private static char findNthNonReaptingChar(String s, int n) {
        final char[] chars = s.toCharArray();
        Map<Character, Integer> hm = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            hm.put(chars[i], hm.containsKey(hm.get(i)) ? hm.get(i) + 1 : 1);
        }
        System.out.println("Final Map : " + hm);
        return hm.entrySet().stream().filter(x -> x.getValue() == 1 ).skip(n-1).map(x -> x.getKey()).findFirst().get();
    }

    private static void findNthNonReaptingCharWithStream(String s, int n) {
        final LinkedHashMap<Character, Long> collect = s.chars().mapToObj(c -> (char) c).filter(ch -> ch != ' ')
                .collect(Collectors.groupingBy(ch -> ch,LinkedHashMap::new,Collectors.counting()));
        System.out.println("Final Map : " + collect);

        collect.entrySet().stream().filter(x -> x.getValue()==1).skip(n-1).map(x-> x.getKey()).findFirst()
                .ifPresent(ch -> System.out.println("5th non-reapting char is : " + ch));


    }




}


