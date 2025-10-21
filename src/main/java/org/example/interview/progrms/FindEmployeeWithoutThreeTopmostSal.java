package org.example.interview.progrms;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;
import java.util.stream.Collectors;

public class FindEmployeeWithoutThreeTopmostSal{

    public static void main(String[] args){
        FindEmployeeWithoutThreeTopmostSal obj = new FindEmployeeWithoutThreeTopmostSal();
        obj.employeeWithoutTopThreeHighestSal();
    }

    private void employeeWithoutTopThreeHighestSal(){

        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();

        final List<EmployeeMap> employeeWithoutTopThreeHighestSal = employeeMaps.stream()
                .sorted((emp1,emp2) -> (int) (emp2.getSalary() - emp1.getSalary()))
                .skip(3)
                .collect(Collectors.toList());

        System.out.println("employeeWithoutTopThreeHighestSal" + employeeWithoutTopThreeHighestSal);

        final List<String> collect = employeeMaps.stream()
                .sorted((emp1,emp2) -> (int) (emp2.getSalary() - emp1.getSalary()))
                .skip(3)
                .map(emp -> emp.getFirstName())
                .collect(Collectors.toList());
        System.out.println("onlyName" + collect);
    }
}
