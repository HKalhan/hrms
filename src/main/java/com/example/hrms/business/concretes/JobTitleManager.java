package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.core.DataResult;
import com.example.hrms.core.Result;
import com.example.hrms.core.SuccessDataResult;
import com.example.hrms.core.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobTitleDao;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>
                (this.jobTitleDao.findAll(),"Data listelendi!");
    }

    @Override
    public Result add(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("İş ünvanı eklendi");
    }
}
