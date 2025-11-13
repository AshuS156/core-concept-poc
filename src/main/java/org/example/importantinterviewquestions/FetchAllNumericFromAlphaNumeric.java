package org.example.importantinterviewquestions;

public class FetchAllNumericFromAlphaNumeric{
    public static void main(String[] args){
        String input = "a1b2c3d4e5f6g7h8i9j0";
        StringBuilder numericPart = new StringBuilder();


        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch >= '0' && ch <= '9'){
                numericPart.append(ch);
            }


        }
        /*for(char ch : input.toCharArray()){
            if(Character.isDigit(ch)){
                numericPart.append(ch);
            }
        }*/

        System.out.println("Numeric part: " + numericPart.toString());
    }
}
