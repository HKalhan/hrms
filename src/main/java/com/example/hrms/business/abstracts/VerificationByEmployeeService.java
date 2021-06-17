package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.VerificationByEmployee;

import java.util.List;

public interface VerificationByEmployeeService {

    Result add(VerificationByEmployee verificationByEmployee);
    Result update(VerificationByEmployee verificationByEmployee, int employeeId);
    Result delete(int id);
    DataResult<List<VerificationByEmployee>> getAll();
    DataResult<VerificationByEmployee> getById(int id);
    DataResult<VerificationByEmployee> getByEmployerId(int employerId);

}
