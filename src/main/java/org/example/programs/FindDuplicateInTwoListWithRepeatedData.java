package org.example.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicateInTwoListWithRepeatedData{
    public static void main(String[] args){

        List<String> al = Arrays.asList("aa","bb","cc", "aa");
        List<String> al2 = Arrays.asList("dd","bb","cc", "cc");

        HashSet<String> hs = new HashSet();

        Set<String> collect = Stream.concat(al.stream(),al2.stream()).filter(a -> !hs.add(a)).collect(Collectors.toSet());
        System.out.println(collect);

        final Set<String> collect1 = al.stream().filter(st1 -> al2.contains(st1)).collect(Collectors.toSet());
        System.out.println(collect);

    }
}
