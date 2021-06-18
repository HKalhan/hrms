package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.VerificationByCodeService;
import com.example.hrms.core.business.BusinessRules;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.VerificationByCodeDao;
import com.example.hrms.entities.concretes.VerificationByCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class VerificationByCodeManager implements VerificationByCodeService {

    private VerificationByCodeDao verificationByCodeDao;
    @Autowired
    public VerificationByCodeManager(VerificationByCodeDao verificationByCodeDao) {
        super();
        this.verificationByCodeDao = verificationByCodeDao;
    }

    @Override
    public Result add(VerificationByCode verificationByCode) {
        this.verificationByCodeDao.save(verificationByCode);
        return new SuccessResult();
    }

    @Override
    public Result update(VerificationByCode verificationByCode) {
        var codeForValidate = this.getByUserId(verificationByCode.getUserId()).getData();

        var result = BusinessRules.run(
                this.checkVerificationCode(codeForValidate.getCode(), verificationByCode.getCode()));
        if(result != null)
            return result;
        codeForValidate.setStatus(true);
        codeForValidate.setVerifiedDate(LocalDateTime.now());
        this.verificationByCodeDao.saveAndFlush(codeForValidate);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        this.verificationByCodeDao.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<VerificationByCode>> getAll() {
        return new SuccessDataResult<List<VerificationByCode>>(this.verificationByCodeDao.findAll());
    }

    @Override
    public DataResult<VerificationByCode> getById(int id) {
        return new SuccessDataResult<VerificationByCode>(this.verificationByCodeDao.getById(id));
    }

    @Override
    public DataResult<VerificationByCode> getByUserId(int userId) {
        return new SuccessDataResult<VerificationByCode>
                (this.verificationByCodeDao.getByUserId(userId));
    }

    private Result checkVerificationCode(String trueCode, String inComingCode){
        if(inComingCode.equals(trueCode))
            return new SuccessResult();
        return new ErrorResult("Verification code does not match.");
    }
}
