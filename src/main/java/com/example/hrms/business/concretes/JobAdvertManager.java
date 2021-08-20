package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.*;
import com.example.hrms.core.utilities.helpers.JobAdvertFilterOption;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.*;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.concretes.verifications.VerificationByEmployee;
import com.example.hrms.entities.concretes.verifications.VerificationTypeEnum;
import com.example.hrms.entities.dto.JobAdvertDto;
import com.example.hrms.entities.dto.JobAdvertFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class JobAdvertManager implements JobAdvertService {





    private JobAdvertDao jobAdvertDao;
    private CityService cityService;
    private EmployerService employerService;
    private JobTitleService jobTitleService;
    private WorkPlaceService workPlaceService;
    private WorkTimeService workTimeService;
    private VerificationByEmployeeService verificationByEmployeeService;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao , CityService cityService, EmployerService employerService,
                            JobTitleService jobTitleService, WorkTimeService workTimeService, WorkPlaceService workPlaceService,
                            VerificationByEmployeeService verificationByEmployeeService) {
        super();
        this.jobAdvertDao = jobAdvertDao;
        this.cityService=cityService;
        this.employerService=employerService;
        this.jobTitleService=jobTitleService;
        this.workPlaceService=workPlaceService;
        this.workTimeService=workTimeService;
        this.verificationByEmployeeService = verificationByEmployeeService;
    }

    @Override
    public Result add(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        var verificationByEmployee= new VerificationByEmployee(jobAdvert.getId() , VerificationTypeEnum.JobAdvert);
        this.verificationByEmployeeService.add(verificationByEmployee);
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
    public Result create(JobAdvertDto jobAdvertDto) {
        JobAdvert jobAdvert=new JobAdvert();

        jobAdvert.setId(0);
        jobAdvert.setActive(true);
        jobAdvert.setApplicationDate(jobAdvertDto.getApplicationDeadline());
        jobAdvert.setApplicationDeadline(jobAdvertDto.getApplicationDeadline());
        jobAdvert.setCity(this.cityService.getById(jobAdvertDto.getCityId()).getData());
        jobAdvert.setEmployer(this.employerService.getById(jobAdvertDto.getEmployerId()).getData());
        jobAdvert.setJobDescription(jobAdvertDto.getJobDescription());
        jobAdvert.setJobTitle(this.jobTitleService.getById(jobAdvertDto.getJobTitleId()).getData());
        jobAdvert.setOpenPositionCount(jobAdvertDto.getOpenPositionCount());
        jobAdvert.setSalaryMax(jobAdvertDto.getSalaryMax());
        jobAdvert.setSalaryMin(jobAdvertDto.getSalaryMin());
        jobAdvert.setWorkPlace(this.workPlaceService.getById(jobAdvertDto.getWorkPlaceId()).getData());
        jobAdvert.setWorkTime(this.workTimeService.getById(jobAdvertDto.getWorkTimeId()).getData());
        this.jobAdvertDao.save(jobAdvert);
        var verificationByEmployee =
                new VerificationByEmployee(jobAdvert.getId(), VerificationTypeEnum.JobAdvert);
        this.verificationByEmployeeService.add(verificationByEmployee);
        return new SuccessResult("Job Advert Added!");
    }

    @Override
    public DataResult<List<JobAdvert>> getJobAdvertRequests() {
        var jobAdverts= this.jobAdvertDao.findAll();
        List<JobAdvert> approvedAdverts = new ArrayList<JobAdvert>();

        for( JobAdvert jobAdvert:jobAdverts) {
            var check = this.verificationByEmployeeService.getByEntityId(jobAdvert.getId()).getData();
            if (!check.isStatus()) {
                 approvedAdverts.add( jobAdvert);
            }
        }
        return new SuccessDataResult<List<JobAdvert>>(approvedAdverts );
    }

    @Override
    public DataResult<List<JobAdvert>> getApprovedJobAdverts() {
        var jobAdverts= this.jobAdvertDao.findAll();
        List<JobAdvert> approvedAdverts = new ArrayList<JobAdvert>();

        for( JobAdvert jobAdvert:jobAdverts) {
            var check = this.verificationByEmployeeService.getByEntityId(jobAdvert.getId()).getData();
            if (check.isStatus()) {
                approvedAdverts.add( jobAdvert);
            }
        }
        return new SuccessDataResult<List<JobAdvert>>(approvedAdverts );
    }

    @Override
    public Result approveJobAdvert(int id) {
        var verification = this.verificationByEmployeeService.getByEntityId(id).getData();
        this.verificationByEmployeeService.approve2(verification);
        return new SuccessResult();
    }

    @Override
    public Result cancelJobAdvert(int id) {
        var verification= this.verificationByEmployeeService.getByEntityId(id).getData();
        var jobAdvert= this.jobAdvertDao.getById( id);
        this.jobAdvertDao.delete( jobAdvert);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobAdvert>> getAllFilterAndPage(int pageNo, int pageSize, JobAdvertFilter advertFilter) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new  SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByFilter(advertFilter, pageable).getContent(),
                this.jobAdvertDao.getByFilter(advertFilter, pageable).getTotalElements()+"");
    }





    }
