package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployeeDao;
import com.example.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        super();
        this.employeeDao = employeeDao;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
    }

    @Override
    public Result add(Employee employee) {
        this.employeeDao.save(employee);
        return new SuccessResult("Employee added.");
    }

    @Override
    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.getById(id));
    }


}
