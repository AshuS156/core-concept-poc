package org.example.importantinterviewquestions;

import java.util.ArrayList;
import java.util.List;

public class playWithListMethod{
    public static void main(String[] args){
        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println(al);
        al.remove(1);
        //al.remove(Integer.valueOf(1));
        System.out.println(al);
        System.out.println(al.get(2));
        al.set(2,10);

        System.out.println(al);

    }
}
