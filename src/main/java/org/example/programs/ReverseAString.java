package org.example.programs;

public class ReverseAString{
    public static void main(String[] args){
        String s = "Hello World";

        // using stream and reduce
        final String reduce = s.chars().mapToObj(ch -> (char) ch).reduce("",(acc,ch) -> ch + acc,(s1,s2) -> s2 + s1);
        System.out.println("reversed string :" + reduce);

        // using stream and reduce without a combiner
        final String reduce1 = s.chars().mapToObj(ch -> (char) ch).map(Object::toString).reduce("",(acc,ch) -> ch + acc);
        System.out.println("reversed string 2 :" + reduce1);

        // using stream and reduce without an identity
        final String reduce2 = s.chars().mapToObj(ch -> (char) ch).map(Object::toString).reduce((acc,ch) -> ch + acc).get();
        System.out.println("reversed string 2 :" + reduce2);

        String reversed = reverseString(s);
        System.out.println("Reversed string: " + reversed);

        // using Stack
        String reversedUsingStack = reverseUsingStack(s);
        System.out.println("Reversed string using stack: " + reversedUsingStack);
    }

    private static String reverseUsingStack(String s){
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for(char ch : s.toCharArray()){
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static String reverseString(String input){
        StringBuilder reversed = new StringBuilder();
        for(int i = input.length() - 1; i >= 0; i--){
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }
}
