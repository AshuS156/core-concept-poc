package org.example.programs;

public class AnagramCheck{
    public static void main(String[] args){
        String str1 = "listen";
        String str2 = "silent";

        if(str1.length() != str2.length()){
            System.out.println("Not anagrams");
            return;
        }

        int[] charCount = new int[26];

        for(int i=0; i<str1.length(); i++){
            charCount[str1.charAt(i) - 'a']++;
            charCount[str2.charAt(i) - 'a']--;
        }

        for(int count : charCount){
            if(count != 0){
                System.out.println("Not anagrams");
                return;
            }
        }

        System.out.println("Anagrams");
    }
}
