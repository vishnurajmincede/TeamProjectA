package com.TeamA.masterTable.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "designation", nullable = false, length = 50)
    private String designation;

    @Column(name = "department", nullable = false, length = 50)
    private String department;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "is_delete")
    private boolean isDelete;
}
