package org.example.importantinterviewquestions;

public class Employee{

    private Integer empId;

    private Double salary;
    private String grade;

    private String city;

    public Employee(Integer empId,Double salary,String grade){
        this.empId = empId;
        this.salary = salary;
        this.grade = grade;
    }

    public Employee(Integer empId,Double salary,String grade,String city){
        this.empId = empId;
        this.salary = salary;
        this.grade = grade;
        this.city = city;
    }

    public Integer getEmpId(){
        return empId;
    }

    public void setEmpId(Integer empId){
        this.empId = empId;
    }

    public Double getSalary(){
        return salary;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    @Override
    public String toString(){
        return "Employee{" +
                "empId=" + empId +
                ", salary=" + salary +
                ", grade='" + grade + '\'' +
                '}';
    }
}
