package org.example.joining;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;
import java.util.stream.Collectors;

public class CollectAllNamesAndJoinAsCommasDelimiter{

    public static void main(String[] args){
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();
        final String collect = employeeMaps.stream()
                .map(emp -> emp.getFirstName().toUpperCase().concat( " ").concat(emp.getLastName().toUpperCase())).collect(Collectors.joining(",  "));
        System.out.println(collect);

    }
}
