package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    Result add(ForeignLanguage foreignLanguage);
    Result update(ForeignLanguage foreignLanguage);
    Result delete(int id);
    DataResult<ForeignLanguage> getById(int id);
    DataResult<List<ForeignLanguage>> getAll();
    DataResult<List<ForeignLanguage>> getAllByCandidateId(int id);

}
