package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.helpers.JobAdvertFilterOption;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dto.JobAdvertDto;
import com.example.hrms.entities.dto.JobAdvertFilter;

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

    Result create(JobAdvertDto jobAdvertDto);
    DataResult<List<JobAdvert>> getJobAdvertRequests();
    DataResult<List<JobAdvert>> getApprovedJobAdverts();
    Result approveJobAdvert(int id);
    Result cancelJobAdvert(int id);

  //  DataResult<List<JobAdvert>> getAll(int pageNo, int pageSize, JobAdvertFilterOption filterOption);


    DataResult<List<JobAdvert>> getAllFilterAndPage(int pageNo, int pageSize, JobAdvertFilter advertFilter);



}
