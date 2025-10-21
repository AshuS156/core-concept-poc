package org.example.customcollectors;

import java.util.stream.Collectors;

public class CountEmployeeBasedOnRatings{
    public static void main(String[] args){

        // Using Collectors.groupingBy to count the number of employees in each rating
        EmployeeUtils.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getRating,Collectors.counting()))
                .forEach((rating, count) -> System.out.println("Rating: " + rating + ", Employee Count: " + count));

    }
}
