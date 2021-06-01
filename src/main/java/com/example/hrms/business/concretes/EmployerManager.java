package com.example.hrms.business.concretes;


import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UserService userService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService) {
        super();
        this.employerDao = employerDao;
        this.userService= userService;

    }
    @Override
    public Result add(Employer employer) {
       if (this.userService.checkEmail(employer.getEmail()).getData()!=null){
           return new ErrorResult("Email adresi daha önce alınmış.");
       }
        this.employerDao.save(employer);
        return new SuccessResult("işveren eklendi");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "iş vererler listelendi");
    }
}
