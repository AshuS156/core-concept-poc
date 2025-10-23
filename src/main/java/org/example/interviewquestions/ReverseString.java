package org.example.interviewquestions;

public class ReverseString{
    public static void main(String[] args){
        reverseString("ashu");
    }

    private static void reverseString(String input){

        final String reduce = input.chars()
                .mapToObj(c -> (char) c)
                .reduce("",(c,s) -> s + c,(s1,s2) -> (s2 + s1));
        System.out.println(reduce);

    }
}
