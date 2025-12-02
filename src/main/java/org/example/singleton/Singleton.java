package org.example.singleton;

import java.util.List;

public final class Singleton{

    private List<String> al;
    private static Singleton instance = null;

    Singleton(List<String> al){
        this.al = al;
    }

    public List<String> getAl(){
        return al;
    }

    public static Singleton getInstance(List<String> al){
        if(instance == null){
            instance = new Singleton(al);
        }
        return instance;
    }
}
