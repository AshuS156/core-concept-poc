package org.example.interviewquestions;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;
import java.util.stream.Collectors;

public class FindEmployeeWithThreeHighestSal{

    public static void main(String[] args){
        FindEmployeeWithThreeHighestSal obj = new FindEmployeeWithThreeHighestSal();
        obj.employeeWithTopThreeHighestSal();
    }

    private void employeeWithTopThreeHighestSal(){

        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();

        final List<EmployeeMap> employeeWithTopThreeHighestSal = employeeMaps.stream()
                .sorted((emp1,emp2) -> (int) (emp2.getSalary() - emp1.getSalary()))
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("employeeWithTopThreeHighestSal" + employeeWithTopThreeHighestSal);
    }
}
