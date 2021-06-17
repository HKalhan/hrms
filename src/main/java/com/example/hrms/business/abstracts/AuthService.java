package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import lombok.Data;

public interface AuthService {

    Result registerCandidate(Candidate candidate,String confirmPassword);
    Result registerEmployer(Employer employer, String confirmPassword);

}