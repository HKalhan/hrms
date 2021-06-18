package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.VerificationByEmployeeService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.VerificationByEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/verificationByEmployeeService")
public class VerificationByEmployeeServicesController {
    private final VerificationByEmployeeService verificationByEmployeeService;

    @Autowired
    public VerificationByEmployeeServicesController(VerificationByEmployeeService verificationByEmployeeService) {
        super();
        this.verificationByEmployeeService = verificationByEmployeeService;
    }
    @PostMapping("/update")
    public Result update(@RequestBody VerificationByEmployee verificationByEmployee, int employeeId) {
        return this.verificationByEmployeeService.update(verificationByEmployee, employeeId);
    }
}
