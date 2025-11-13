package org.example.immutable;

import java.util.Date;
import java.util.Objects;

public final class  CustomImmutable{

    private final String name;
    private final Double salary ;

    private final Date dob;;

    public CustomImmutable(String name, Double salary, Date dob) {
        this.name = name;
        this.salary = salary;
        // Defensive copy to maintain immutability
        this.dob = dob != null ? new Date(dob.getTime()) : null;
    }

    public String getName(){
        return name;
    }

    public Double getSalary(){
        return salary;
    }

    public Date getDob(){
        return dob != null ? new Date(dob.getTime()) : null;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomImmutable that = (CustomImmutable) o;
        return Objects.equals(name,that.name) && Objects.equals(salary,that.salary) && Objects.equals(dob,that.dob);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,salary,dob);
    }
}
