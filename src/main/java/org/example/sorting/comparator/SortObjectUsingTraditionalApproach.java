package org.example.sorting.comparator;


import java.util.Collections;
import java.util.List;

public
class SortObjectUsingTraditionalApproach {

    public static void main(String[] args) {
        List<Employee> listOfEmp = EmployeeDBUtils.getEmployees();
        System.out.println("Employee object before sorting .......");
        listOfEmp.forEach(System.out::println);
        System.out.println("Employee object after sorting .......");
        Collections.sort(listOfEmp,new EmpNameComparator());
        listOfEmp.forEach(System.out::println);

    }
}
