package org.example.playwithcomparator;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PlayWithComparatorMethods{
    public static void main(String[] args){
        // Comparator methods: comparing, thenComparing, reversed, naturalOrder, nullsFirst, nullsLast
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();
        sortEmployeeBasedOnSalaryAndRating(employeeMaps);
        sortEmployeeBasedonLastNameAndNullasFist(employeeMaps);
        sortEmployeeBasedonLastNameAndNullasLast(employeeMaps);
        playWithComapringDouble(employeeMaps);
    }

    private static void sortEmployeeBasedonLastNameAndNullasLast(List<EmployeeMap> employeeMaps){

        final List<EmployeeMap> collect = employeeMaps.stream().limit(5).sorted(Comparator.comparing(EmployeeMap::getLastName,
                                                                                                     Comparator.nullsLast(Comparator.naturalOrder())))
                .collect(Collectors.toList());
        System.out.println("Employee sorted based on Lastname with nullLast :"+ collect);
    }

    private static void playWithComapringDouble(List<EmployeeMap> employeeMaps){
        final List<EmployeeMap> playWithComapringDouble = employeeMaps.stream().
                limit(5).sorted(Comparator.comparingDouble(EmployeeMap::getSalary)).collect(Collectors.toList());
        System.out.println("Employee sorted based on Salary using comparingDouble :"+ playWithComapringDouble);
    }

    private static void sortEmployeeBasedonLastNameAndNullasFist(List<EmployeeMap> employeeMaps){

        final Comparator<EmployeeMap> comparing = Comparator.comparing(EmployeeMap::getLastName,Comparator.nullsFirst(Comparator.naturalOrder()));
        final List<EmployeeMap> sortedLastNameWithNullFirst = employeeMaps.stream()
                .limit(5)
                .sorted(comparing)
                .collect(Collectors.toList());
        System.out.println("Employee sorted based on LastName with nullFirst :"+ sortedLastNameWithNullFirst);


        final List<EmployeeMap> collect = employeeMaps.stream()
                .limit(5)
                .sorted(Comparator.comparing(EmployeeMap::getLastName,Comparator.nullsFirst(Comparator.naturalOrder())))
                .collect(Collectors.toList());
        System.out.println("Employee sorted based on LastName with nullFirst using inline comparator :"+ collect);

        final List<String> nullFirstLastNames = employeeMaps.stream()
                .limit(5).map(employeeMap -> employeeMap.getLastName())
                .sorted(Comparator.nullsFirst(Comparator.naturalOrder())).collect(Collectors.toList());
        System.out.println("Employee with nullFirst as LastNames :"+ nullFirstLastNames);


    }

    private static void sortEmployeeBasedOnSalaryAndRating(List<EmployeeMap> employeeMaps){
        employeeMaps.stream().limit(5).sorted(Comparator.comparing(EmployeeMap::getSalary).thenComparing(EmployeeMap::getRating))
                .forEach(System.out::println);
    }
}
