package org.example.consumerChaining;

import javax.sound.midi.Soundbank;
import java.util.function.Consumer;

public class ConsumerChaining{
    public static void main(String[] args){

        Consumer<Integer> doubleIt = (i) -> System.out.println("Double: " + (i * 2));
        doubleIt.accept(5); // Double: 10
        Consumer<Integer> squareIt = (i) -> System.out.println("Square: " + (i * i));
        squareIt.accept(5); // Square: 25

        // Double: 6 \n Square: 9
        doubleIt.andThen(squareIt).accept(5);
    }
}
