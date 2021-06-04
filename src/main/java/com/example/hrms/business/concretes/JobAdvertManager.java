package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobAdvertDao;
import com.example.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao) {
        super();
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public Result add(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("iş ilanı eklendi");
    }

    @Override
    public Result update(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("iş ilanı güncellendi");
    }

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvert>> getAllSortedByDate() {
        Sort sort = Sort.by(Sort.Direction.DESC,"applicationDeadline");
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort));
    }

    @Override
    public DataResult<JobAdvert> getById(int id) {
        return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getById(id));
    }

    @Override
    public DataResult<List<JobAdvert>> getAllActiveJobAdvert() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActiveJobAdvert());
    }

    @Override
    public DataResult<List<JobAdvert>> findAllByOrderByPublishedAtDesc() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByOrderByPublishedAtDesc());
    }

    @Override
    public DataResult<List<JobAdvert>> getAllActiveJobAdvertByEmployer(int id) {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActiveJobAdvertByEmployer(id));
    }

    @Override
    public Result changeOpenToClose(int id) {
        if (getById(id)==null){
            return new ErrorResult("Böyle bir iş ilanı yok");
        }
        if (getById(id).getData().isActive()==false){
            return new ErrorResult("bu iş ilanı artık kapalı");
        }
        JobAdvert jobAdvert= getById(id).getData();
        jobAdvert.setActive(false);
        update(jobAdvert);
        return new SuccessResult("iş ilanı başarıyla kaldırıldı");


    }
}
