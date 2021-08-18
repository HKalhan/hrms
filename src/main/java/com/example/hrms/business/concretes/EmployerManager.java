package com.example.hrms.business.concretes;


import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dto.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UserService userService;
    private ImageService imageService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService) {
        super();
        this.employerDao = employerDao;
        this.userService= userService;

    }
    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Employer added");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer listed");
    }

    @Override
    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email));
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.getById(id));
    }

    @Override
    public DataResult<List<EmployerDto>> getEmployerDto() {
        return new SuccessDataResult<List<EmployerDto>>(this.employerDao.getEmployerDto());
    }


}
