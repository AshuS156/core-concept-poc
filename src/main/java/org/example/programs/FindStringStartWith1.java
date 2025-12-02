package org.example.programs;

import java.util.List;
import java.util.stream.Collectors;

public class FindStringStartWith1{
    public static void main(String[] args){
        List<Integer> al = List.of(1,11,14,32,44,17);
        final List<String> collect = al.stream().map(ch -> ch.toString()).filter(ob1 -> ob1.startsWith("1")).collect(Collectors.toList());
        System.out.println(collect);
        collect.stream().forEach(e -> System.out.println(Integer.parseInt(e)));
    }

}
