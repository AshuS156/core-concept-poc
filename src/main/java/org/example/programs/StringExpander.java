package org.example.programs;

public class StringExpander{
    public static void main(String[] args) {
        String expand = "w3r4y6ab2";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expand.length(); i++) {
            char currentChar = expand.charAt(i);

            // Check if the next character is a digit
            if (i + 1 < expand.length() && Character.isDigit(expand.charAt(i + 1))) {
                int repeatCount = Character.getNumericValue(expand.charAt(i + 1));
                result.append(String.valueOf(currentChar).repeat(repeatCount));
                i++; // Skip the digit
            } else {
                result.append(currentChar);
            }
        }

        System.out.println(result.toString());
    }
}
