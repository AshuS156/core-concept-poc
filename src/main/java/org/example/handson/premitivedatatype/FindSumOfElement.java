package org.example.handson.premitivedatatype;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
  Question: WAP to calculate a sum of element
 */
public class FindSumOfElement{
    public static void main(String[] args){
        int arr[] = {11,23,43,56,34,65,33,44};

        // Approach 1: Using Arrays.stream().sum()
        final int sum = Arrays.stream(arr).sum();
        System.out.println("Approach-1: Using Arrays.stream().sum() ::" +sum);

        // 2. Approach: Using IntStream and sCollectors.summingInt
        final Integer collect = Arrays.stream(arr).boxed().collect(Collectors.summingInt(i -> i));
        System.out.println("Approach-2: Using IntStream and sCollectors.summingInt ::" +collect);


        Arrays.stream(arr).boxed().mapToInt(i -> i).sum();
        // 2.1 Approach: Using IntStream and sCollectors.summingInt with method reference
        final Integer collectWithMethodRef = Arrays.stream(arr).boxed().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Approach-2.1: Using IntStream and sCollectors.summingInt with method reference ::" +collectWithMethodRef);

        // 2.2 Approach: Using IntStream and sCollectors.summingInt with lambda expression
        final Integer collectWithLambda = Arrays.stream(arr).boxed().collect(Collectors.summingInt(i -> i.intValue()));
        System.out.println("Approach-2.2: Using IntStream and sCollectors.summingInt with lambda expression ::" +collectWithLambda);

        // 2.3 Approach: Using IntStream and sCollectors.summingInt with boxed
        final Integer collectWithBoxed = Arrays.stream(arr).boxed().collect(Collectors.summingInt(Integer::valueOf));
        System.out.println("Approach-2.3: Using IntStream and sCollectors.summingInt with boxed ::" +collectWithBoxed);

        // 3. Approach: Using IntStream and reduce
        final Integer reduce = Arrays.stream(arr).boxed().reduce(0, (a, b) -> a + b);
        System.out.println("Approach-3: Using IntStream and reduce ::" +reduce);

        // 4. Approach: Using IntStream and reduce with method reference
        final Integer reduceWithMethodRef = Arrays.stream(arr).boxed().reduce(0, Integer::sum);
        System.out.println("Approach-4: Using IntStream and reduce with method reference ::" +reduceWithMethodRef);

    }
}
