package org.example.interview.questions;


import org.example.sorting.comparator.*;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDepartmnetWiseMaxSalary{
    public static void main(String[] args){
        final List<Employee> employees = EmployeeDBUtils.getEmployees();
        final Map<String, DoubleSummaryStatistics> collect = employees.stream().
                collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summarizingDouble(Employee::getSalary)));
        System.out.println(collect);


    }
}
