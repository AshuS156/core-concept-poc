package org.example.playwithmap;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayWithMap{
    public static void main(String[] args){

        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();
      /*  System.out.println(employeeMaps);

        final Stream<String> stringStream = employeeMaps.stream().map(EmployeeMap::getFirstName);
        System.out.println(stringStream);
        // Get all first names
        employeeMaps.stream().map(EmployeeMap::getFirstName).forEach(System.out::println);
        System.out.println("----------------");
        // uppercase all first names and get entire employee object
        employeeMaps.stream().map(employeeMap -> {
            employeeMap.setFirstName(employeeMap.getFirstName().toUpperCase());
            return employeeMap;
        }).forEach(System.out::println);
*/


        final Map<String, EmployeeMap> listToMap = employeeMaps.stream()
                .collect(Collectors.toMap(EmployeeMap::getEmployeeId,e -> e));
        System.out.println("Convert a list to map using employeeId as key" + listToMap);
    }
}
