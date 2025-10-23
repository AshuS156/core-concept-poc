package org.example.playwithpartitioning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayWithPartitioning{
    public static void main(String[] args){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        final Map<Boolean, List<Integer>> collect = numbers.stream().map(a -> a.intValue()).collect(Collectors.partitioningBy(val -> val % 2 == 0));
        System.out.println(collect);

    }
}
