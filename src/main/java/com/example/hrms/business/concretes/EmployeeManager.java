package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployeeDao;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employee;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private EmployerDao employerDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, EmployerDao employerDao) {
        super();
        this.employeeDao = employeeDao;
        this.employerDao= employerDao;
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

    @Override
    public Result update(int id, String email, String password, String passwordRepeat, String firstName, String lastName) {
        Employee employee = this.employeeDao.getById(id);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setPasswordRepeat(passwordRepeat);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        this.employeeDao.save(employee);
        return new SuccessResult("Employee has been updated");
    }

    @Override
    public Result confirmUpdateEmployer(int employerId) {
        Employer employer = employerDao.getOne(employerId);
        Map<String, Object> jsonUpdate = employer.getHistory();
        employer.setEmail(jsonUpdate.get("email").toString());
        employer.setPassword(jsonUpdate.get("password").toString());
        employer.setPasswordRepeat(jsonUpdate.get("passwordRepeat").toString());
        employer.setCompanyName(jsonUpdate.get("companyName").toString());
        employer.setWebAddress(jsonUpdate.get("webAddress").toString());
        employer.setPhoneNumber(jsonUpdate.get("phoneNumber").toString());
        employer.setHistory(null);
        employer.setActivated(true);
        this.employerDao.save(employer);
        return new SuccessResult("updated.");
    }


}
