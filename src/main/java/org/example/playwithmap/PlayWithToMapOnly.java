package org.example.playwithmap;

import java.util.*;
import java.util.stream.Collectors;

public class PlayWithToMapOnly{

    public static void main(String[] args){
        Person person1 = new Person("1","Alice",30);
        Person person2 = new Person("2","Bob",25);
        Person person3 = new Person("3","Charlie",35);
        Person person4 = new Person("2","David",28); // Duplicate ID to test behavior
        Person person5 = new Person("4","Eve",22);
        Person person6 = new Person("3","Frank",40); // Duplicate ID to test behavior
        Person person7 = new Person("5","Grace",27);

        List<Person> personList = Arrays.asList(person6, person7, person1,person2,person3,person4,person5);
        System.out.println("Person List: " + personList);
        // if any duplicate keys are found,then below will throw IllegalStateException
        //  java.lang.IllegalStateException: Duplicate key 2
        // so to resolve that we can provide a merge function as 3rd parameter to toMap method
        //Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getId,p -> p));
       // System.out.println("Person Map: " + personMap);


        // Using merge function to handle duplicate keys, keeping the new value
        Map<String, Person> personMap1=  personList.stream()
                .collect(Collectors.toMap(Person::getId, person -> person, (oldValue, newValue) -> newValue));
        System.out.println("Person Map with merge function (keeping new value): " + personMap1);

        // Using merge function to handle duplicate keys, keeping the old value
        Map<String, Person> personMap2=  personList.stream()
                .collect(Collectors.toMap(Person::getId, person -> person, (oldValue, newValue) -> oldValue));
        System.out.println("Person Map with merge function (keeping old value): " + personMap2);

        // Using TreeMap to have sorted keys
        Map<String, Person> personMap3=  personList.stream()
                .collect(Collectors.toMap(Person::getId, person -> person, (oldValue, newValue) -> newValue, TreeMap::new));
        System.out.println("Person Map with TreeMap (sorted keys): " + personMap3);

        // Using LinkedHashMap to preserve insertion order
        Map<String, Person> personMap4=  personList.stream()
                .collect(Collectors.toMap(Person::getId, person -> person, (oldValue, newValue) -> newValue, LinkedHashMap::new));
        System.out.println("Person Map with LinkedHashMap (insertion order): " + personMap4);
    }
}
