package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "verification_by_employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class VerificationByEmployee extends Verification{

    @Column(name="employer_id") //böyle bi hata yaptığıma inanamıyorum şuan :D
    private  int employerId;


    @Column(name="employee_id")
    private Integer employeeId;


}

