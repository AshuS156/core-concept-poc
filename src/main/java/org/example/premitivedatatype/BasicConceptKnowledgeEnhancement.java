package org.example.premitivedatatype;

import java.util.Arrays;

public class BasicConceptKnowledgeEnhancement {

    public static void main(String[] args) {
        String str = "hi ashu how are you doing today";

        // Splitting the string into words and characters
        final String[] withSpace =str.split(" ");
        final String[] withoutSpace =str.split("");
        System.out.println("Splits with space as delimeter" + Arrays.toString(withSpace));
        System.out.println("Splits without space as delimeter" + Arrays.toString(withoutSpace));

        // Finding the mutliple  of the integer array
        int arr[]= {2,3,4,1,3};
        final Integer reduce = Arrays.stream(arr).boxed().reduce(1, (a, b) -> a * b);
        System.out.println("Approach-3: Using IntStream and reduce ::" +reduce);

        //WAP to Calculate the sum of 10,20,30,44 only based on input - String str = "item1 10 item2 22 item3 33 item4 44"?
        String input = "item1 10 item2 22 item3 33 item4 44";
        final int sum = Arrays.stream(input.split(" "))
                .filter(s -> s.matches("\\d+")) // Filter only numeric strings
                .mapToInt(Integer::parseInt) // Convert to integers
                .sum(); // Sum them up
        System.out.println("Sum of numbers in the input string: " + sum);

    }
}
