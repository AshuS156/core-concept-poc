package org.example.equalAndhascode;

public class Employee{

    private int id;
    private String name;

    private double salary;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public Employee(int id,String name,double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

  /*  @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Employee emp = (Employee) obj;
        return id == emp.id && name.equals(emp.name) && Double.compare(emp.salary, salary) == 0;
    }*/
    public int hashCode(){
        int result;
        long temp;
        result = Integer.hashCode(id);
        result = 31 * result + name.hashCode();
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

   /* public int hashCode(){
        return  name.hashCode()+ id;
    }*/
}
