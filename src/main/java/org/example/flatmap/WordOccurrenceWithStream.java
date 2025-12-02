package org.example.flatmap;

import java.util.List;

public class WordOccurrenceWithStream{
    public static void main(String[] args) {
        List<String> list = List.of("I Love Java","Java is cool","I Like Java and I also work in java");
        String dynamicWord = "Java"; // Replace with the word you want to search for

        long count = list.stream()
                .flatMap(sentence -> List.of(sentence.split("\\s+")).stream()) // Split sentences into words
                .filter(word -> word.equalsIgnoreCase(dynamicWord)) // Filter matching words
                .count(); // Count occurrences

        System.out.println("The word '" + dynamicWord + "' occurred " + count + " times.");
    }
}
