package com.example.hrms.core.utilities.verifications;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService {


    @Override
    public void verifyByCode(String code, String email) {
        System.out.println(code+" kod "+email +"hesabınıza gönderildi");
    }

    @Override
    public void verifyByEmployee(int id) {
        System.out.println(id + "ID değerli hesap çalışan tarafından onaylandı");
    }
}
