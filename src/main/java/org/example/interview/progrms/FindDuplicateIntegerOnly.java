package org.example.interview.progrms;

import java.util.Arrays;
import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateIntegerOnly{
    public static void main(String[] args){
        List<Integer> al = Arrays.asList(11,22,33,22,44,55,70,33);

        Set<Integer> hs = new HashSet<>();

        final List<Integer> duplicateElementOnly = al.stream().filter((num -> !hs.add(num))).collect(Collectors.toList());
        System.out.println(duplicateElementOnly);
    }

}
