package org.example.programs;

public class CollectAllNUmericWithoutUsingInBuiltFunction{

    public static void main(String[] args){
        CollectAllNUmericWithoutUsingInBuiltFunction obj = new CollectAllNUmericWithoutUsingInBuiltFunction();
        obj.collectNumericChars();
        numericData();
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


    private static String numericData() {
        String str = "45df4e4r8t";
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()) {
            if(ch>='0' && ch<='9') {
                sb.append(ch);
            }


        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
