package org.example.groupingwithmapping;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingWithMappings{
    public static void main(String[] args){
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();
        final Map<String, List<String>> collect = employeeMaps.stream()
                .collect(Collectors.groupingBy(EmployeeMap::getEmail,
                                               Collectors.mapping(EmployeeMap::getFirstName, Collectors.toList())));
        System.out.println("Grouping with mapping : "+ collect);

    }

}
