package org.example.programs;

import org.example.importantinterviewquestions.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindCityCount{
    public static void main(String[] args){
        org.example.importantinterviewquestions.Employee e1 = new org.example.importantinterviewquestions.Employee(1,Double.valueOf(44000),"A","Bangalore");
        org.example.importantinterviewquestions.Employee e2 = new org.example.importantinterviewquestions.Employee(11,Double.valueOf(44000),"D","Delhi");
        org.example.importantinterviewquestions.Employee e3 = new org.example.importantinterviewquestions.Employee(122,Double.valueOf(44000),"B","Kanpur");
        org.example.importantinterviewquestions.Employee e4 = new org.example.importantinterviewquestions.Employee(111,Double.valueOf(44000),"X","Chennai");
        org.example.importantinterviewquestions.Employee e5 = new org.example.importantinterviewquestions.Employee(123,Double.valueOf(44000),"A","Delhi");
        org.example.importantinterviewquestions.Employee e6 = new org.example.importantinterviewquestions.Employee(144,Double.valueOf(44000),"G","Bangalore");
        org.example.importantinterviewquestions.Employee e7 = new org.example.importantinterviewquestions.Employee(155,Double.valueOf(44000),"H","Bangalore");

        final List<Employee> list = Arrays.asList(e1,e2,e3,e4,e5,e6,e7);

        final Map<String, Long> collect = list.stream().map(e -> e.getCity()).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect);

        final String key = collect.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst().get().getKey();
        System.out.println(key);
        collect.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                findFirst().get().getValue();
    }
}
