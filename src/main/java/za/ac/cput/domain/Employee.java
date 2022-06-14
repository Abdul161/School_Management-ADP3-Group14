package za.ac.cput.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.*;
import java.util.*;

@Entity
public class Employee implements Serializable
{
    @Id @NotNull
    private String staffId;
    @NotNull
    private String email;
    @OneToOne
    @JoinColumn(name = "emp_name",nullable = false)
    private Name name;//Error as Name entity must be created

    protected Employee(){
        //constructor
    }

    private Employee(Builder b){
        this.staffId = b.staffId;
        this.email = b.email;
        this.name = b.name;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "staffId='" + staffId + '\'' +
                ", email='" + email + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return staffId.equals(employee.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }

    public static class Builder{
        private String staffId;
        private String email;
        private Name name;

        public Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder name(Name name){
            this.name = name;
            return this;
        }
        public Builder copy(Employee e){
            this.staffId = e.staffId;
            this.email = e.email;
            this.name = e.name;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

}


