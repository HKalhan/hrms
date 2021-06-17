package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.VerificationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.VerificationDao;
import com.example.hrms.entities.concretes.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationManager implements VerificationService {
     private VerificationDao verificationDao;

     @Autowired
    public VerificationManager(VerificationDao verificationDao) {
        super();
        this.verificationDao = verificationDao;
    }


    @Override
    public Result add(Verification verification) {
        this.verificationDao.save(verification);
        return new SuccessResult();
    }

    @Override
    public Result update(Verification verification) {
        this.verificationDao.save(verification);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        this.verificationDao.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Verification>> getAll() {
        return new SuccessDataResult<List<Verification>>(this.verificationDao.findAll());
    }


    @Override
    public DataResult<Verification> getById(int id) {
        return new SuccessDataResult<Verification>(this.verificationDao.getById(id));
    }
}
