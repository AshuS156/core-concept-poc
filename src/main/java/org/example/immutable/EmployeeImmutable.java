package org.example.immutable;

import org.example.playwithsorting.Employee;

public final class EmployeeImmutable{

    private final String userName;
    private final int age;

    private final Address address;

    public EmployeeImmutable(String userName,int age,Address address) throws CloneNotSupportedException{
        this.userName = userName;
        this.age = age;
        // Defensive copy to maintain immutability
        this.address = (Address)address.clone();
    }

    public String getUserName(){
        return userName;
    }
    public int getAge(){
        return age;
    }
    public Address getAddress() throws CloneNotSupportedException{
        return (Address)address.clone();
    }

    @Override
    public String toString(){
        return "EmployeeImmutable{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args){
        try {
            EmployeeImmutable employeeImmutable = new EmployeeImmutable("John",30,new Address("123 Main St","Springfield","IL"));
            System.out.println("Employee Immutable Address before modification: " + employeeImmutable + "hashcode :" + employeeImmutable.hashCode());
            // Attempting to modify the address obtained from the getter
            Address addressFromGetter = employeeImmutable.getAddress();
            addressFromGetter.setCity("Bangalore");
            System.out.println("Employee Immutable Address After modification: " + employeeImmutable + "hashcode :" + employeeImmutable.hashCode());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

}
