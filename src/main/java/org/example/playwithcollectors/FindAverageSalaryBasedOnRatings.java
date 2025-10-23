package org.example.playwithcollectors;

import java.util.Map;
import java.util.stream.Collectors;

public class FindAverageSalaryBasedOnRatings{
    public static void main(String[] args){
        // Using Collectors.groupingBy to group employees by rating and then calculating the total salary for each rating
        final Map<String, Double> totalSalaryByRating = EmployeeUtils.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getRating,
                                               Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Total Salary by Rating: " + totalSalaryByRating);


        // Using Collectors.groupingBy to group employees by rating and then calculating the average salary for each rating
        final Map<String, Double> collect = EmployeeUtils.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getRating,
                                               Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average Salary by Rating: " + collect);

    }
}
