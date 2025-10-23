package org.example.playwithsorting;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapBasedOnkeyExample{
    public static void main(String[] args){

        // Implementation will be added soon
        Map<String, Integer> sampleMap = Map.of("banana",3,"apple",5,"orange",2,"grape",4);
        System.out.println("Sample Map: " + sampleMap);

        // sort map using comparator and by key
        final LinkedHashMap<String, Integer> collect = sampleMap.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2) -> e1,LinkedHashMap::new));
        System.out.println("Sorted Map using Comparator: " + collect);


        // sort map using comparingByKey
        sampleMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("comparingByKey -Key: " + entry.getKey() + ", Value: " + entry.getValue()));


    }
}
