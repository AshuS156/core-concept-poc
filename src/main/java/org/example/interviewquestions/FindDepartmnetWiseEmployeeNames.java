package org.example.interviewquestions;


import org.example.playwithsorting.Employee;
import org.example.playwithsorting.EmployeeDBUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDepartmnetWiseEmployeeNames{
    public static void main(String[] args){
        final List<Employee> employees = EmployeeDBUtils.getEmployees();
        final Map<String, List<String>> mappings = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,Collectors.mapping(
                                Employee::getEmpName,Collectors.toList())));
        System.out.println(mappings);
    }
}
