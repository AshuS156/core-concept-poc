package org.example.cloning;

public class DriverMain{
    public static void main(String[] args) throws CloneNotSupportedException{

        Address address = new Address("123 Main St", "Springfield", "IL");
        User originalUser = new User("JohnDoe", 30, address);


         User userClonedObject =null;
        try {
            userClonedObject = (User) originalUser.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Original User: " + originalUser);
        System.out.println("Cloned User: " + userClonedObject);

        System.out.println("\nAfter modifying the cloned object's address city to Bangalore:\n");
        originalUser.getAddress().setCity("Bangalore");
        System.out.println("Original User: " + originalUser);
        System.out.println("Cloned User: " + userClonedObject);
    }
}
