package org.example.interview.progrms;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployeeBasedonSalary{

    public static void main(String[] args){
        SortEmployeeBasedonSalary obj = new SortEmployeeBasedonSalary();
        obj.sortEmployeeBasedonSalary();
    }

    private void sortEmployeeBasedonSalary(){

        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();

        final List<EmployeeMap> employeeBasedOnHiherSal = employeeMaps.stream().sorted((emp1,emp2) -> (int) (emp2.getSalary() - emp1.getSalary())).collect(Collectors.toList());

        System.out.println("employeeSortingBasedOnHigherSal" + employeeBasedOnHiherSal);
    }
}
