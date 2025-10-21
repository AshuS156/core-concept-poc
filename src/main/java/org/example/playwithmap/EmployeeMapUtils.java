package org.example.playwithmap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface EmployeeMapUtils{

    public static List<EmployeeMap> loadEmployee(){
        ObjectMapper objectMapper = new ObjectMapper();
         List<EmployeeMap> employeeMaps = null;
            try {
               employeeMaps = objectMapper.readValue(new File("employeeMap.json"),new TypeReference<List<EmployeeMap>>(){
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        System.out.println("Employee data loaded from JSON file.");
        return employeeMaps;
        }

}
