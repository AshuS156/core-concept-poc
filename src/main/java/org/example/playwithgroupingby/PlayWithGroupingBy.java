package org.example.playwithgroupingby;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class PlayWithGroupingBy{
    public static void main(String[] args){
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();
        groupByWithOneParam(employeeMaps);
        groupByWithTwoParam(employeeMaps);
        groupByWithThreeParam(employeeMaps);

        final Map<String, Set<String>> collect = employeeMaps.stream()
                .collect(Collectors.groupingBy(EmployeeMap::getEmail,
                                               Collectors.mapping(EmployeeMap::getFirstName,Collectors.toSet())));
        System.out.println("Grouping with mapping : "+ collect);

    }

    private static void groupByWithOneParam(List<EmployeeMap> employeeMaps){
        final Map<String, List<EmployeeMap>> collect = employeeMaps.stream().
                                  collect(Collectors.groupingBy(emp -> emp.getNewJoiner()));

        System.out.println("Grouping by one param : "+ collect);
    }

    private static void groupByWithTwoParam(List<EmployeeMap> employeeMaps){
        final Map<String, Set<EmployeeMap>> collect = employeeMaps.stream().
                collect(Collectors.groupingBy(emp -> emp.getNewJoiner(),Collectors.toSet()));
        System.out.println("Grouping by two param : "+ collect);

    }

    private static void groupByWithThreeParam(List<EmployeeMap> employeeMaps){
        final Map<String, Set<EmployeeMap>> collect = employeeMaps.stream().
                collect(Collectors.groupingBy(emp -> emp.getNewJoiner(),TreeMap::new , Collectors.toSet()));
        System.out.println("Grouping by three param : "+ collect);

    }


}
