package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.verifications.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationDao extends JpaRepository<Verification, Integer> {

    Verification getById(int id);
}
