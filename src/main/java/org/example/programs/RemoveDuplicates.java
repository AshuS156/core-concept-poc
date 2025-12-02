package org.example.programs;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates{

    public static void main(String[] args) {
        String input = "ABCDEABCD";

        // Use a LinkedHashSet to maintain the order of last occurrence
        Set<Character> hasSet = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        // Traverse the string in reverse order
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (!hasSet.contains(c)) {
                hasSet.add(c);
                result.insert(0, c); // Insert at the beginning to reverse the order
            }
        }

        System.out.println(result.toString());
    }
}
