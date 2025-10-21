package org.example.customcollectors;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatteningExample{
    public static void main(String[] args){
        System.out.println("Flattening Example");
        Stream<Stream<String>> streamOfStreams = Stream.of(
                Stream.of("A", "B", "C"),
                Stream.of("D", "E", "F"),
                Stream.of("G", "H", "I")
        );

        streamOfStreams.flatMap(stream -> stream)
                .forEach(System.out::print);


        List<List<String>> phoneNumbers = List.of(
                List.of("123-456-7890", "987-654-3210"),
                List.of("555-555-5555", "666-666-6666"),
                List.of("111-222-3333", "444-555-6666")
        );

        System.out.println("\n-------------\n" + phoneNumbers);
        final List<String> collect = phoneNumbers.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collect);
    }
}
