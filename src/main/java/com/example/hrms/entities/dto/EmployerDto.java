package com.example.hrms.entities.dto;


import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDto {
 private int id;
    private String companyName;
    private String email;
    private String webAddress;
    private String phoneNumber;
    private String description;
    private String url;

}