package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;

public interface VerificationCodeService {
    Result add(int id);
    String createCode();
}
