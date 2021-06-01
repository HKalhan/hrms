package com.example.hrms.core.verifications;

import com.example.hrms.core.verifications.VerificationService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
