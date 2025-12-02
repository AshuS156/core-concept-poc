package org.example.programs;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;

public class FindNthHieghtestSalary{
    public static void main(String[] args){

        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();
        int n = 3; // Find the 3rd highest salary
        final Double nthHighestSalary = findNthHighestSalary(employeeMaps,n);
        System.out.println(n + "th highest salary is: " + nthHighestSalary);


    }

    private static Double findNthHighestSalary(List<EmployeeMap> employeeMaps,int n){
        return employeeMaps.stream()
                .map(emp -> emp.getSalary())
                .distinct()
                .sorted((s1,s2) -> (int) (s2 - s1)) // Sort in descending order
                .skip(n - 1) // Skip the first n-1 salaries
                .findFirst() // Get the nth highest salary
                .orElse(null); // Return null if not found
    }
}
