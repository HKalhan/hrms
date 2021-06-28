package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.*;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dto.JobAdvertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;
    private CityDao cityDao;
    private EmployerDao employerDao;
    private JobTitleDao jobTitleDao;
    private WorkPlaceDao workPlaceDao;
    private WorkTimeDao workTimeDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao , CityDao cityDao, EmployerDao employerDao,
                            JobTitleDao jobTitleDao, WorkTimeDao workTimeDao, WorkPlaceDao workPlaceDao) {
        super();
        this.jobAdvertDao = jobAdvertDao;
        this.cityDao=cityDao;
        this.employerDao=employerDao;
        this.jobTitleDao=jobTitleDao;
        this.workPlaceDao=workPlaceDao;
        this.workTimeDao=workTimeDao;
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

    @Override
    public Result create(JobAdvertDto jobAdvertDto) {
        JobAdvert jobAdvert=new JobAdvert();

        jobAdvert.setId(jobAdvertDto.getId());
        jobAdvert.setActive(true);
        jobAdvert.setApplicationDate(jobAdvertDto.getApplicationDeadline());
        jobAdvert.setApplicationDeadline(jobAdvertDto.getApplicationDeadline());
        jobAdvert.setCity(this.cityDao.getById(jobAdvertDto.getCityId()));
        jobAdvert.setEmployer(this.employerDao.getById(jobAdvertDto.getEmployerId()));
        jobAdvert.setJobDescription(jobAdvertDto.getJobDescription());
        jobAdvert.setJobTitle(this.jobTitleDao.getById(jobAdvertDto.getJobTitleId()));
        jobAdvert.setOpenPositionCount(jobAdvertDto.getOpenPositionCount());
        jobAdvert.setPublishedAt(LocalDate.now());
        jobAdvert.setSalaryMax(jobAdvertDto.getSalaryMax());
        jobAdvert.setSalaryMin(jobAdvertDto.getSalaryMin());
        jobAdvert.setWorkPlace(this.workPlaceDao.getById(jobAdvertDto.getWorkPlaceId()));
        jobAdvert.setWorkTime(this.workTimeDao.getById(jobAdvertDto.getWorkTimeId()));
        this.jobAdvertDao.save(jobAdvert);

        return new SuccessResult("Job Advert Added!");
    }
}
