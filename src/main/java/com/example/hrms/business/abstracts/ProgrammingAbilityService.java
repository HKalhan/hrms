package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.ProgrammingAbility;

import java.util.List;

public interface ProgrammingAbilityService {
    Result add(ProgrammingAbility programmingAbility);
    Result update(ProgrammingAbility programmingAbility);
    Result delete(int id);
    DataResult<ProgrammingAbility> getById(int id);
    DataResult<List<ProgrammingAbility>> getAll();
    DataResult<List<ProgrammingAbility>> getAllByCandidateId(int id);

}
