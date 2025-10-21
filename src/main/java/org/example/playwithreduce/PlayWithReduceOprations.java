package org.example.playwithreduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PlayWithReduceOprations{
    public static void main(String[] args){
        List<Integer> elements = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        final Integer reduce = elements.stream().reduce(0,(a,b) -> a + b);
        System.out.println("Sum using reduce: " + reduce);

        final Optional<Integer> reduce1 = elements.stream().reduce((a,b) -> a + b);
        System.out.println("Sum using reduce without identity: " + reduce1.orElse(0));

    }
}
