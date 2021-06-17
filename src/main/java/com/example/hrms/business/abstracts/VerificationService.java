package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Verification;

import java.util.List;

public interface VerificationService {
    Result add(Verification verification);
    Result update(Verification verification);
    Result delete(int id);
    DataResult<List<Verification>> getAll();
    DataResult<Verification> getById(int id);
}
