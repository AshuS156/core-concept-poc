package org.example.playwithcollectors;

import java.util.Map;
import java.util.stream.Collectors;

public class FindTotalSalaryForEachDepartment{
    public static void main(String[] args){
        // Using Collectors.groupingBy to group employees by department and then calculating the total salary for each department
        final Map<String, Double> totalSalaryByDepartment = EmployeeUtils.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                                               Collectors.summingDouble(Employee::getSalary)));
        System.out.println("Total Salary by Department: " + totalSalaryByDepartment);
    }
}
