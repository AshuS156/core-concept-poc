package org.example.importantinterviewquestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicateInTwoList{
    public static void main(String[] args){

        List<String> al = Arrays.asList("aa","bb","cc");
        List<String> al2 = Arrays.asList("dd","bb","cc");

        HashSet<String> hs = new HashSet();

        List<String> collect = Stream.concat(al.stream(),al2.stream()).filter(a -> !hs.add(a)).collect(Collectors.toList());
        System.out.println(collect);

    }
}
