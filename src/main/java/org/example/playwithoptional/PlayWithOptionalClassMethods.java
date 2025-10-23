package org.example.playwithoptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
   Optional class methods:
   of, ofNullable , empty , isEmpty , get ,orElse , orElseGet , orElseThrow ,
   ifPresent , filter , map , flatMap
 */
public class PlayWithOptionalClassMethods{
    public static void main(String[] args){

        //create Optional Object
        final Optional<List<Integer>> list = Optional.of(Arrays.asList(1,2,3,4));
        final Optional<List<String>> list1 = Optional.ofNullable(Arrays.asList("ashu","raman","prabhu","sanjay"));
        final Optional<Object> emptyOptional = Optional.empty();

        // play with isPresent and isEmpty

        list.ifPresent(integers -> System.out.println("List is present and its values are : " + integers));
        // play with orElse , orElseGet , orElseThrow
        final List<String> strings = list1.orElseGet(() -> Arrays.asList("default1","default2"));
        System.out.println("List of strings using orElseGet : " + strings);

        final List<String> strings1 = list1.orElse(Arrays.asList("default3","default4"));
        System.out.println("List of strings using orElse : " + strings1);
        // play with orElseThrow
        try {
            final List<String> objects = (List<String>) list1.orElseThrow(() -> new Exception("No value present in Optional Object"));
            System.out.println("List of strings using orElseThrow : " + objects);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // play with orElseThrow
        try {
            final List<String> objects = (List<String>) emptyOptional.orElseThrow(() -> new Exception("No value present in Optional Object"));
            System.out.println("Empty Optional using orElseThrow : " + objects);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        // play with filter
        final Optional<List<Integer>> filteredOptional = list.filter(integers -> integers.size() > 3);
        System.out.println("Filtered Optional : " + filteredOptional);

        //isPresent and get
        if(filteredOptional.isPresent()){
            final List<Integer> integers = filteredOptional.get();
            System.out.println("Values from filtered Optional using get() : " + integers);
        }

        // play with ifPresentOrElse
        list1.ifPresentOrElse(strings2 -> System.out.println("Values from list1 using ifPresentOrElse : " + strings2),
                () -> System.out.println("No value present in list1"));


        //difference between orElse and orElseGet
        final List<String> strings2 = list1.orElse(getDefaultList());  // getDefaultList will be called even though list1 is present
        System.out.println("List of strings using orElse : " + strings2);
        final List<String> strings3 = list1.orElseGet(() -> getDefaultList());  // getDefaultList will not be called as list1 is present
        System.out.println("List of strings using orElse : " + strings2);
    }

    private static List<String> getDefaultList(){
        System.out.println("getDefaultList() method called");
        return Arrays.asList("Java","Spring");
    }
}
