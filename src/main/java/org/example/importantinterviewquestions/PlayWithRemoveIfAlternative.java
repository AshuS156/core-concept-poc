package org.example.importantinterviewquestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayWithRemoveIfAlternative{
    public static void main(String[] args){
        List<String> names= Arrays.asList("Ashu","Bob","Hemant","John","ankit");
        final List<String> updatedList = names.stream().peek(n -> System.out.println(n))
                .filter(n -> !n.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(updatedList);

        names.removeIf(n -> n.startsWith("A")); // throw unsupported operation exception
        System.out.println(names);
    }
}
