package org.example.customcollectors;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

    public static Employee createEmployee(int id, String name, int age, String department, String rating, Double salary, String city, String country, String state) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setDepartment(department);
        employee.setRating(rating);
        employee.setSalary(salary);
        employee.setCity(city);
        employee.setCountry(country);
        employee.setState(state);
        return employee;
    }
    public static List<Employee> getEmployees() {
       /* List<Employee> employees = new ArrayList<>();
        employees.add(EmployeeUtils.createEmployee(1, "John Doe", 30, "Engineering", "A", 75000.0, "New York", "USA", "NY"));
        employees.add(EmployeeUtils.createEmployee(2, "Jane Smith", 28, "Marketing", "B", 65000.0, "Los Angeles", "USA", "CA"));
        employees.add(EmployeeUtils.createEmployee(3, "Alice Johnson", 35, "HR", "A", 70000.0, "Chicago", "USA", "IL"));
        employees.add(EmployeeUtils.createEmployee(4, "Bob Brown", 40, "Finance", "C", 80000.0, "Houston", "USA", "TX"));
        return employees;*/
        List<Employee> employees = new ArrayList<>();
        employees.add(EmployeeUtils.createEmployee(1, "John Doe", 30, "Engineering", "A", 75000.0, "New York", "USA", "NY"));
        employees.add(EmployeeUtils.createEmployee(2, "Jane Smith", 28, "Marketing", "B", 65000.0, "Los Angeles", "USA", "CA"));
        employees.add(EmployeeUtils.createEmployee(3, "Alice Johnson", 35, "HR", "A", 70000.0, "Chicago", "USA", "IL"));
        employees.add(EmployeeUtils.createEmployee(4, "Bob Brown", 40, "Finance", "C", 80000.0, "Houston", "USA", "TX"));
        employees.add(EmployeeUtils.createEmployee(5, "Charlie Davis", 32, "Engineering", "B", 72000.0, "San Francisco", "USA", "CA"));
        employees.add(EmployeeUtils.createEmployee(6, "Diana Prince", 29, "Marketing", "A", 68000.0, "Seattle", "USA", "WA"));
        employees.add(EmployeeUtils.createEmployee(7, "Eve Adams", 45, "HR", "C", 75000.0, "Boston", "USA", "MA"));
        employees.add(EmployeeUtils.createEmployee(8, "Frank White", 50, "Finance", "B", 85000.0, "Miami", "USA", "FL"));
        return employees;
    }


}
