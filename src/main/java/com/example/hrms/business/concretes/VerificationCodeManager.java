package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.VerificationCodeService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.VerificationDao;
import com.example.hrms.entities.concretes.verifications.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

@Service
public class VerificationCodeManager implements VerificationCodeService {
    VerificationDao verificationDao;

    @Autowired
    public VerificationCodeManager(VerificationDao verificationDao) {
        super();
        this.verificationDao = verificationDao;
    }
    @Override
    public Result addUser(int userId) {
        Verification verification=new Verification();
        verification.setVerified(true);
        verification.setVerificationCode(this.createCode());
        verification.setUserId(userId);

       this.verificationDao.save(verification);
       return new SuccessResult();
    }

    @Override
    public String createCode() {
        UUID code = UUID.randomUUID();
        return code.toString().toLowerCase(Locale.ROOT);
    }
}
