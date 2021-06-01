package com.example.hrms.core.verifications;

import com.example.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;


public interface VerificationService {
    void verifyByCode (String code,String email);
    void verifyByEmployee(int id);

}
