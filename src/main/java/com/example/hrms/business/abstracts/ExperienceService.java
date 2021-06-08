package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {
    Result add(Experience experience);
    Result update(Experience experience);
    Result delete(int id);
    DataResult<Experience> getById(int id);
    DataResult<List<Experience>> getAll();
    DataResult<List<Experience>> getAllByCandidate_idOrderByLeaveDateDesc(int id);
    DataResult<List<Experience>> getAllByCandidate_id(int id);
}
