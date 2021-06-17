package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    Result add(Candidate candidate);
    DataResult<List<Candidate>> getAll();
    DataResult<Candidate > getByEmail(String email);
    DataResult<Candidate > getByIdentificationNumber(String identificationNumber);
    DataResult<Candidate> getById(int id);


}
