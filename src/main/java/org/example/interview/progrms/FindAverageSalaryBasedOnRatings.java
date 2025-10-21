package org.example.interview.progrms;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindAverageSalaryBasedOnRatings{
    public static void main(String[] args){
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();
        final Map<Integer, Double> averageSalPaidBasedOnRatings = employeeMaps.stream()
                .collect(Collectors.groupingBy(emp -> emp.getRating(),Collectors.averagingDouble(emp -> emp.getSalary())));

        System.out.println("Average salary based on ratings : "+ averageSalPaidBasedOnRatings);

        // print map in more readable format
        averageSalPaidBasedOnRatings.forEach((rating,avgSal) -> {
            System.out.println("Rating : "+ rating + " Average Salary : "+ avgSal);
        });

        // find the highest salary based on ratings
        Comparator<EmployeeMap> salaryComparator = Comparator.comparingDouble(emp -> emp.getSalary());
        final Map<Integer, Optional<EmployeeMap>> maxSalPaidBasedOnRatings = employeeMaps.stream()
                .collect(Collectors.groupingBy(emp -> emp.getRating(),Collectors.maxBy(salaryComparator)));
        System.out.println("Employee with Highest Salary based on ratings : "+ maxSalPaidBasedOnRatings);


        final Map<Integer, Double> totalSalPaidBasedOnRatings = employeeMaps.stream()
                .collect(Collectors.groupingBy(emp -> emp.getRating(),Collectors.summingDouble(emp -> emp.getSalary())));
        System.out.println("Total salary based on ratings : "+ totalSalPaidBasedOnRatings);


        final Map<Integer, Long> countEmpBasedOnRatings = employeeMaps.stream()
                .collect(Collectors.groupingBy(emp -> emp.getRating(),Collectors.counting()));
        System.out.println("Count of employees based on ratings : "+ countEmpBasedOnRatings);


        final Map<Integer, List<String>> collect = employeeMaps.stream()
                .collect(Collectors.groupingBy(emp -> emp.getRating(),Collectors.mapping(emp -> emp.getNewJoiner(),Collectors.toList())));

        System.out.println(collect);

        final Map<Integer, Map<Boolean, List<EmployeeMap>>> collect1 = employeeMaps.stream()
                .collect(Collectors.groupingBy(emp -> emp.getRating(),Collectors.partitioningBy(emp -> emp.getSalary() > 5000)));

        final Map<Boolean, List<EmployeeMap>> collect2 = employeeMaps.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() > 5000));
        System.out.println(collect1);

    }
}
