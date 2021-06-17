package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.VerificationByCode;

import java.util.List;

public interface VerificationByCodeService {
    Result add(VerificationByCode verificationByCode);
    Result update(VerificationByCode verificationByCode);
    Result delete(int id);
    DataResult<List<VerificationByCode>> getAll();
    DataResult<VerificationByCode> getById(int id);
}
