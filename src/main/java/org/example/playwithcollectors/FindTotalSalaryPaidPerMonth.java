package org.example.playwithcollectors;

import java.util.stream.Collectors;

public class FindTotalSalaryPaidPerMonth{
    public static void main(String[] args){

        // Using Collectors.summingDouble to calculate the total salary paid per month
        final double totalSalaryPaidPerMonth = EmployeeUtils.getEmployees().stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println("Total Salary Paid Per Month: " + totalSalaryPaidPerMonth);

        // Alternatively, using mapToDouble and sum to achieve the same result
        final double sum = EmployeeUtils.getEmployees().stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Total Salary Paid Per Month (using mapToDouble): " + sum);

        final Double reduce = EmployeeUtils.getEmployees().stream()
                .map(Employee::getSalary)
                .reduce(0.0,Double::sum);
        System.out.println("Total Salary Paid Per Month (using reduce): " + reduce);
        // Using reduce with a lambda expression to calculate the total salary paid per month
        EmployeeUtils.getEmployees().stream()
                .map(Employee::getSalary)
                .reduce(0.0,(o1, o2) -> o1 + o2);

        System.out.println("Total Salary Paid Per Month (using reduce with lambda): " + reduce);

    }

}
