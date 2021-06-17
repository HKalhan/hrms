package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.EmployeeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/emloyees")
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }


    @GetMapping("/getall")
    public DataResult<List<Employee>> getAll(){
        return this.employeeService.getAll();
    }


    @PostMapping("/add")
    public Result add(@RequestBody Employee employee){
        return this.employeeService.add(employee);
    }

    @GetMapping("/getById")
    public DataResult<Employee> getById(@RequestParam("id") int id){
        return this.employeeService.getById(id);
    }

}
