package org.example.customcollectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortElementUsingCustomCollectors{
    public static void main(String[] args) throws InterruptedException{
        List<String> list = Arrays.asList("banana","apple","orange","grape");

        sortAndStoredIntoCustomCollector(list);
        basicSortingUsingCollectors(list);
        sortListBasedOnElementLength(list);

    }


    private static void sortAndStoredIntoCustomCollector(List<String> list){
        list.stream().sorted().collect(Collector.of(LinkedList::new,LinkedList::add,(left,right) -> {
            left.addAll(right);
            return left;
        })).forEach(System.out::println);
    }

    private static void basicSortingUsingCollectors(List<String> list){
        System.out.println("Basic Sorting Using Collectors:");
        list.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void sortListBasedOnElementLength(List<String> list){
        list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()).forEach(System.out::println);
    }
}
