package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.VerificationByEmployeeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.VerificationByEmployeeDao;
import com.example.hrms.entities.concretes.VerificationByEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificationByEmployeeManager implements VerificationByEmployeeService {


    private VerificationByEmployeeDao verificationByEmployeeDao;

    @Autowired
    public VerificationByEmployeeManager(VerificationByEmployeeDao verificationByEmployeeDao) {
        super();
        this.verificationByEmployeeDao = verificationByEmployeeDao;
    }


    @Override
    public Result add(VerificationByEmployee verificationByEmployee) {
        this.verificationByEmployeeDao.save(verificationByEmployee);
        return new SuccessResult();
    }

    @Override
    public Result update(VerificationByEmployee verificationByEmployee, int employeeId) {
        this.verificationByEmployeeDao.save(verificationByEmployee);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        this.verificationByEmployeeDao.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<VerificationByEmployee>> getAll() {
        return new SuccessDataResult<List<VerificationByEmployee>>(this.verificationByEmployeeDao.findAll());
    }

    @Override
    public DataResult<VerificationByEmployee> getById(int id) {
        return new SuccessDataResult<VerificationByEmployee>(this.verificationByEmployeeDao.getById(id));
    }

    @Override
    public DataResult<VerificationByEmployee> getByEmployerId(int employerId) {
        return new  SuccessDataResult<VerificationByEmployee>(this.verificationByEmployeeDao.getByEmployerId(employerId));
    }
}
