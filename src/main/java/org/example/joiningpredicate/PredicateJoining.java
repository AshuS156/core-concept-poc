package org.example.joiningpredicate;

import java.util.function.Predicate;

public class PredicateJoining{
    public static void main(String[] args){


        Predicate<String> predicateLength = (s) -> s.length() > 5;

        System.out.println("Predicate test for 'HelloWorld': " + predicateLength.test("HelloWorld"));
        Predicate<String> predicateLengthEven = (s) -> s.length() % 2 == 0;
        System.out.println("Predicate test for even length 'Hello': " + predicateLengthEven.test("Hello"));

        Predicate<String> predicateContainsA = (s) -> s.contains("a");
        System.out.println("Predicate test for contains 'a' in 'Java': " + predicateContainsA.test("Java"));

        final boolean helloWorld = predicateLength.and(predicateLengthEven).test("HelloWorld");

        System.out.println("Predicate test for 'HelloWorld' with AND: " + helloWorld);

        final boolean java = predicateLength.or(predicateContainsA).test("Java");

        System.out.println("Predicate test for 'Java' with OR: " + java);

        // Testing negate - which will work with only one predicate for ex: predicateLength
        final boolean negate = predicateLength.negate().test("Java");
        System.out.println("Predicate test for 'Java' with Negate: " + negate);


    }
}
