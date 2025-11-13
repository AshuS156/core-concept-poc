package org.example.cloning;

public class Address implements  Cloneable{

    private String street;
    private String city;
    private String state;

    public Address(String street,String city,String state){
        this.street = street;
        this.city = city;
        this.state = state;
    }


    public void setStreet(String street){
        this.street = street;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getStreet(){
        return street;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    protected Object clone() throws CloneNotSupportedException {
        System.out.println("Clone method of Address class called");
        return (Address)super.clone();
    }

    @Override
    public String toString(){
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

