package org.example;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.*;
import java.util.stream.Collectors;

public class TestYourseself{
    public static void main(String[] args){
        System.out.println("Hello Test Yourself");

        int arr[]= {2,3,4,2,36,7,3,4,5,6,7,8,9,1,0,2};
        Set<Integer> set = new HashSet<>();
        final List<Integer> collect = Arrays.stream(arr).filter(element -> !set.add(element)).boxed().collect(Collectors.toList());
        System.out.println(collect);

        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();
        final Map<String, List<EmployeeMap>> collect1 = employeeMaps.stream().collect(Collectors.groupingBy(emp -> emp.getFirstName()));


        final List<EmployeeMap> collect2 = employeeMaps.stream().sorted(Comparator.comparing(EmployeeMap::getSalary).reversed()).collect(Collectors.toList());
        collect2.stream().limit(3).collect(Collectors.toList()).forEach(
                emp -> System.out.println("name" + emp.getFirstName() + "Salary :"+ emp.getSalary())
        );

        employeeMaps.stream().sorted(Comparator.comparing(EmployeeMap::getSalary).reversed())
                .forEach(emp -> System.out.println(emp.getFirstName() + " : " + emp.getSalary()));


        int add[] = {22,33,44};
        final int reduce = Arrays.stream(add).reduce(0,(a,b) -> a + b);
        System.out.println("Sum of element using reduce : "+ reduce);

        final long sum = Arrays.stream(add).summaryStatistics().getSum();
        System.out.println("Sum of element using summaryStatistics : "+ sum);

        final IntSummaryStatistics sum2 = Arrays.stream(add).summaryStatistics();
        System.out.println("IntSummaryStatistics"+  sum2);

        // sum of salary of all empl

        //1. summaryStatics, reduce, suumingDouble

        final double sum1 = employeeMaps.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getSum();
        System.out.println("summaryStatistics :"+ sum1);
        final Double collect4 = employeeMaps.stream().collect(Collectors.summingDouble(emp -> emp.getSalary()));
        System.out.println("summingDouble :"+ collect4);
        final DoubleSummaryStatistics collect5 = employeeMaps.stream().collect(Collectors.summarizingDouble(emp -> emp.getSalary()));
        System.out.println("summarizingDouble :"+ collect5);
        final Double reduce1 = employeeMaps.stream().map(emp -> emp.getSalary()).reduce(Double.valueOf(0),(o1,o2) -> o1 + o2);
        System.out.println("reduce : "+ reduce1);


        // differential all employee whose salary less than 1 lakh
        final Map<Boolean, List<EmployeeMap>> collect3 = employeeMaps.stream().collect(Collectors.partitioningBy(emp -> emp.getSalary() > 100000));
        System.out.println(collect3);

        // sort an aaray in desc order
        int arr2[]= {23,76,46,5,4,32};
      Arrays.stream(arr2).mapToObj(a -> a).sorted((o1, o2) -> o2-o1).forEach(x -> System.out.println(x));


    }

}
