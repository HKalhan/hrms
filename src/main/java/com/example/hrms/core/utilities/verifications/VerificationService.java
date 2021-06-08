package com.example.hrms.core.utilities.verifications;


public interface VerificationService {
    void verifyByCode (String code,String email);
    void verifyByEmployee(int id);

}
