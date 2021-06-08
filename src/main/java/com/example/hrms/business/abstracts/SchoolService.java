package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    Result add(School school);
    SuccessResult update(School school);
    Result delete(int id);
    DataResult<School> getById(int id);
    DataResult<List<School>> getAll();
    DataResult<List<School>> getAllByCandidateId(int id);
    DataResult<List<School>> getByCandidateOrderByGraduationDateDesc(int id);
}
