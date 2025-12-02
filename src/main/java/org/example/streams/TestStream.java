package org.example.streams;

import java.util.stream.Stream;

public class TestStream{
    public static void main(String[] args){
        final Stream<Integer> integerStream = Stream.of(1,2,3);
        integerStream.forEach(System.out::println);
        integerStream.forEach(System.out::println);


    }
}
