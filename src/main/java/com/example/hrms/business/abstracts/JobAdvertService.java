package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {

    Result add (JobAdvert jobAdvert);
    Result update(JobAdvert jobAdvert);
    DataResult<List<JobAdvert>> getAll();
    DataResult<List<JobAdvert>> getAllSortedByDate();
    DataResult<JobAdvert> getById(int id);
    DataResult<List<JobAdvert>> getAllActiveJobAdvert();
    DataResult<List<JobAdvert>>  findAllByOrderByPublishedAtDesc();
    DataResult<List<JobAdvert>> getAllActiveJobAdvertByEmployer(int id);
    Result changeOpenToClose(int id);

}
