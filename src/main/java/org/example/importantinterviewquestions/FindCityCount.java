package org.example.importantinterviewquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindCityCount{
    public static void main(String[] args){
        Employee e1 = new Employee(1, Double.valueOf(44000), "A", "Bangalore");
        Employee e2 = new Employee(11, Double.valueOf(44000), "D", "Delhi");
        Employee e3 = new Employee(122, Double.valueOf(44000), "B", "Kanpur");
        Employee e4 = new Employee(111, Double.valueOf(44000), "X", "Chennai");
        Employee e5 = new Employee(123, Double.valueOf(44000), "A", "Delhi");
        Employee e6 = new Employee(144, Double.valueOf(44000), "G", "Bangalore");
        Employee e7 = new Employee(155, Double.valueOf(44000), "H", "Bangalore");

        final List<Employee> list = Arrays.asList(e1,e2,e3,e4,e5,e6,e7);

        final Map<String, Long> collect = list.stream().map(e -> e.getCity()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect);

        final String key = collect.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().get().getKey();
        System.out.println(key);

    }
}
