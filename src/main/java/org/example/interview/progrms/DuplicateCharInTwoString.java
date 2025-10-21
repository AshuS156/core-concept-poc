package org.example.interview.progrms;

public class DuplicateCharInTwoString{
    public static void main(String[] args){
        String str1 = "apple";
        String str2 = "grape";

        System.out.println("Duplicate characters between \"" + str1 + "\" and \"" + str2 + "\":");
        findDuplicateCharacters(str1, str2);
    }

    private static void findDuplicateCharacters(String str1,String str2){
        System.out.println(str1.toCharArray());
        for(char c : str1.toCharArray()){
           // System.out.println("c : " + c +  ", str2.indexOf(c) " + str2.indexOf(c));
            // check if character is present in second string
            if(str2.indexOf(c) != -1){
              System.out.print(c + " ");
            }
        }
    }
}
