package org.example.importantinterviewquestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinTwoListWithoutDuplicateElement{

    public static void main(String[] args){

        List<Integer> al1 = Arrays.asList(1,2,3,4,5);
        List<Integer> al2 = Arrays.asList(4,5,6,7,8);
        Stream.concat(al1.stream(),al2.stream()).distinct().collect(Collectors.toList()).forEach(System.out::println);




    }
}
