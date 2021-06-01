package com.example.hrms.entities.concretes.verifications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "verification_by_employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationByEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="employee_id")
    private int employeeId;

    @Column(name="employer_id")
    private  int employerId;

    @Column(name="is_confirmed")
    private boolean isConfirmed;
}

