package org.example.interview.progrms;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;

public class FondSecondAndThirdYongestEmployee{
    public static void main(String[] args){

        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();

        employeeMaps.stream().sorted((emp1,emp2) -> emp1.getAge() - emp2.getAge()).skip(1).limit(2).forEach(System.out::println);

    }
}
