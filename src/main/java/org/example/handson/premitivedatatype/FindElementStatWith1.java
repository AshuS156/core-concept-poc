package org.example.handson.premitivedatatype;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Question: WAP to find all elements start with 1
 */
public class FindElementStatWith1{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,15,6,7,18,9,10};

        final List<String> elementStartWithPrefix1 = Arrays.stream(arr).mapToObj(i -> i + "").filter(obj -> obj.startsWith("1")).collect(Collectors.toList());
        System.out.println(elementStartWithPrefix1);

    }
}
