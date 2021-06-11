package com.example.freshinsights.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Employee")
public class Employee
{
    @Id
    @Column(name = "empId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    BigInteger empId;

    @Column(name = "empName")
    String empName;

    @Column(name = "password")
    String password;

    @Column(name = "type")
    String type;

    @Column(name = "createdAt")
    LocalDateTime createdAt;

    @Column(name = "updatedAt")
    LocalDateTime updatedAt;

    public void setCreatedAt()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        createdAt = LocalDateTime.now();
        dtf.format(createdAt);
    }

    public void setUpdatedAt()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        updatedAt = LocalDateTime.now();
        dtf.format(updatedAt);
    }
}
