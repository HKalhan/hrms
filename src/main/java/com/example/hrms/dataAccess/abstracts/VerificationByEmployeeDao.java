package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.VerificationByEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationByEmployeeDao extends JpaRepository<VerificationByEmployee ,Integer> {

    VerificationByEmployee getById(int id);
    VerificationByEmployee getByEmployerId(int employerId);
}
