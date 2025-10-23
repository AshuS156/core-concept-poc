package org.example.importantinterviewquestions;

public class ShiftZeroToLeftOrRight{
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12,0,5,0,0,8};
        shiftZeroToRight(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    private static void shiftZeroToRight(int[] arr){
        int nonZeroIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }
        while(nonZeroIndex < arr.length){
            arr[nonZeroIndex++] = 0;
        }
    }
}
