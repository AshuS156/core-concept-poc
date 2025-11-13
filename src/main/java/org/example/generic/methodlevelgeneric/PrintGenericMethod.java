package org.example.generic.methodlevelgeneric;

import java.util.Map;

public class PrintGenericMethod{

    public static void main(String[] args){
        PrintGenericMethod pgm = new PrintGenericMethod();
        pgm.<String>printData("Hello, Generic Method!");
        pgm.<Integer>printData(12345);
        pgm.<Double>printData(67.89);
        pgm.<String, Integer>printKeyValue("Age",30);
        pgm.<Integer, String>printKeyValue(1,"One");
        pgm.<String, String, String>printKeyValue("Name","Alice","Additional Data");
        System.out.println(pgm.returnInputData("Test String"));
        Map<String, Integer> map = Map.of("One",1,"Two",2);

    }


    public <K,V> Map<K,V> createMap(Map<K,V> inputMap){
       return inputMap;
    }

    public <T> void printData(T data){
        System.out.println("Data: " + data);
    }

    public <K,V> void printKeyValue(K key,V value){
        System.out.println("Key: " + key + ", Value: " + value);

    }

    public <K,V,T> T printKeyValue(K key,V value,T data){
        System.out.println("Key: " + key + ", Value: " + value + " , data : " + data);
        return data;

    }

    public <T> T returnInputData(T data){
        return data;
    }
}
