package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.VerificationByCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationByCodeDao extends JpaRepository<VerificationByCode, Integer> {

    VerificationByCode getById(int id);
    VerificationByCode getByUserId(int userId);
}
