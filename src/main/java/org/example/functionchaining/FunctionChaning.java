package org.example.functionchaining;

import java.util.function.Function;

public class FunctionChaning{
    public static void main(String[] args){

        Function<Integer, Integer> doubleIt = (i) -> i * 2;
        System.out.println("Result of doubleIt for 3: " + doubleIt.apply(3)); // 6
        Function<Integer , Integer> cubeIt = (i) -> i* i * i;
        System.out.println("Result of cubeIt for 3: " + cubeIt.apply(3)); // 27

        final Integer andThen = doubleIt.andThen(cubeIt).apply(3);
        System.out.println("Result of andThen (double then cube) for 3: " + andThen); // (3*2)^3 = 216
        final Integer compose = doubleIt.compose(cubeIt).apply(3);
        System.out.println("Result of compose (cube then double) for 3: " + compose); // (3^3)*2 = 54


    }
}
