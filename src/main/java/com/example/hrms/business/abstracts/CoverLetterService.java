package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService {
    Result add(CoverLetter coverLetter);
    Result update(CoverLetter coverLetter);
    Result delete(int id);
    DataResult<List<CoverLetter>> getAll();
    DataResult<List<CoverLetter>> getByCandidate_id(int id);
}
