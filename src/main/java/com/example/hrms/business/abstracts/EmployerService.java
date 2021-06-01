package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    Result add(Employer employer);
    DataResult<List<Employer>> getAll();
}
