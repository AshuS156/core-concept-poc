package org.example.counting;

import java.util.List;
import java.util.stream.Collectors;

public class PlayWithCounting{
    public static void main(String[] args){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final long count = numbers.stream().count();
        System.out.println(count);

        final Long collect = numbers.stream().collect(Collectors.counting());
        System.out.println(collect);
    }
}
