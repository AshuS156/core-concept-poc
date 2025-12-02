package org.example.programs;

// Employee.java

public class Employee {
    private int id;
    private String name;
    private int age;
    private String city;
    private String department;
    private double salary;
    private String email;
    private String phone;
    private String address;
    private String designation;

    // Constructor
    public Employee(int id, String name, int age, String city, String department, double salary, String email, String phone, String address, String designation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.designation = designation;
    }

    public Employee(int id, String name, String city, String department, double salary ) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCity() { return city; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getDesignation() { return designation; }


    @Override
    public String toString(){
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}