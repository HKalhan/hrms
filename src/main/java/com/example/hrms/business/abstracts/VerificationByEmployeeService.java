package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.verifications.VerificationByEmployee;

import java.util.List;

public interface VerificationByEmployeeService {

    Result add(VerificationByEmployee verificationByEmployee);

    Result delete(VerificationByEmployee verificationByEmployee);
    DataResult<List<VerificationByEmployee>> getAll();
    DataResult<VerificationByEmployee> getById(int id);
   // DataResult<VerificationByEmployee> getByEmployerId(int employerId);
    DataResult<VerificationByEmployee> getByEntityId(int entityId);
    Result approve2(VerificationByEmployee verificationByEmployee);

}
