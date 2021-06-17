package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.VerificationByCodeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.VerificationByCodeDao;
import com.example.hrms.entities.concretes.VerificationByCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        this.verificationByCodeDao.save(verificationByCode);
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



}
