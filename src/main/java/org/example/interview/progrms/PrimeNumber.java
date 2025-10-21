package org.example.interview.progrms;

public class PrimeNumber{
    public static void main(String[] args){

        // Check if a number is prime number or not
        // Prime number is a number that is only divisible by 1 and itself
        // like 2, 3, 7,11,13,17,19
        System.out.println(isPrimeNumber(20));
    }

    private static boolean isPrimeNumber(int num) {
        boolean isDivisable = false;

        for(int i=2; i< num;i++) {
            if(num % i==0) {
                isDivisable = true;
                break;
            }
        }
        return num > 1 && !isDivisable;

    }
}
