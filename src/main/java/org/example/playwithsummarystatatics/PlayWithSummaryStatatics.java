package org.example.playwithsummarystatatics;

import org.example.playwithmap.EmployeeMap;
import org.example.playwithmap.EmployeeMapUtils;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

public class PlayWithSummaryStatatics{

    public static void main(String[] args){
        final List<EmployeeMap> employeeMaps = EmployeeMapUtils.loadEmployee();

        // Get summary statistics of ratings
        final IntSummaryStatistics ratingsStatics = employeeMaps.stream().mapToInt(emp -> emp.getRating()).summaryStatistics();
        System.out.println("ratings : "+ ratingsStatics);

// Get summary statistics of salary
        final DoubleSummaryStatistics salaryStatics =
                employeeMaps.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics();

        System.out.println("salary  : "+ salaryStatics);
    }
}
