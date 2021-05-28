package com.example.hrms.business.abstracts;
import com.example.hrms.core.DataResult;
import com.example.hrms.core.Result;
import com.example.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();
    Result add(JobTitle jobTitle);
}
