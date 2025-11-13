package org.example.cloning;

public class User implements Cloneable{

    private String userName;
    private int age;
    private Address address;

    public User(String userName,int age,Address address) throws CloneNotSupportedException{
        this.userName = userName;
        this.age = age;
        this.address = address;
    }

    public String getUserName(){
        return userName;
    }

    public int getAge(){
        return age;
    }

    public Address getAddress(){
        return address;
    }

    public Object clone() throws CloneNotSupportedException {
        System.out.println("Clone method of User class called");
        User clonedUser = (User)super.clone();
       clonedUser.address = (Address)address.clone();
        return clonedUser;
    }

    @Override
    public String toString(){
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
