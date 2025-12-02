package org.example.programs;

public class ReverseEachCharInGivenString{

    public static void main(String[] args) {
        String input = "hello world";

        String reversed = input.chars()
                .mapToObj(c -> (char) c)
                //dlrow olleh
               .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);

        System.out.println("Reversed String: " + reversed);
    }
}
