package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> getAll();
    Result add(Employee employee);
    DataResult<Employee> getById(int id);
    Result update(int id,String email,String password,String passwordRepeat,String firstName,String lastName);
    Result confirmUpdateEmployer(int employerId);

}
