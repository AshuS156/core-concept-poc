package org.example.interviewquestions;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberUsingStream{
    public static void main(String[] args){

        // Check if a number is prime number or not
        // Prime number is a number that is only divisible by 1 and itself
        // like 2, 3, 7,11,13,17,19
        System.out.println(isPrimeNumber(19));
    }

    private static boolean isPrimeNumber(int i){

        //public static IntStream range(int startInclusive, int endExclusive) {
        IntStream.range(2,i).forEach(x -> System.out.println(x));
        return i> 1 && IntStream.range(2,i).noneMatch(num -> i % num == 0);
    }


}
