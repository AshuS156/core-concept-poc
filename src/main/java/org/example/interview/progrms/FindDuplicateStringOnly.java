package org.example.interview.progrms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDuplicateStringOnly{
    public static void main(String[] args){

        String str = "welcome to code decode and code decode welcome you all";
        final String[] strArrays = str.split(" ");

        final List<String> list = Arrays.asList(strArrays);

        final Set<String> collect2 = list.stream().filter(st -> Collections.frequency(list,st) > 1).collect(Collectors.toSet());
        System.out.println(collect2);
    }
}
