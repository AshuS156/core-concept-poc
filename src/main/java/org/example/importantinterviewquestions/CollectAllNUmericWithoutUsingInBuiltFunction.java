package org.example.importantinterviewquestions;

public class CollectAllNUmericWithoutUsingInBuiltFunction{

    public static void main(String[] args){
        CollectAllNUmericWithoutUsingInBuiltFunction obj = new CollectAllNUmericWithoutUsingInBuiltFunction();
        obj.collectNumericChars();
    }
    String str = "ab3c4d5e6" ;
    public void collectNumericChars(){
        char[] charArray = str.toCharArray();
        StringBuilder numericChars = new StringBuilder();
        for(char ch : charArray){
            if(ch >= '0' && ch <= '9'){
                numericChars.append(ch);
            }
        }
        System.out.println("Numeric characters: " + numericChars.toString());
    }

}
