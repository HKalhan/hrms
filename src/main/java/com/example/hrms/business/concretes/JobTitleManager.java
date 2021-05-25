package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobTitleService;
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
    public List<JobTitle> getAll() {
        return this.jobTitleDao.findAll();
    }
}
