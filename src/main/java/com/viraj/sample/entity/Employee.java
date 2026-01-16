package com.viraj.sample.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;

    @Column(name = "EMPLOYEE_DESCRIPTION")
    private String employeeDescription;

    public Employee() {
    }

    public Employee(String employeeName, String employeeDescription) {
        this.employeeName = employeeName;
        this.employeeDescription = employeeDescription;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeDescription='" + employeeDescription + '\'' +
                '}';
    }
}
