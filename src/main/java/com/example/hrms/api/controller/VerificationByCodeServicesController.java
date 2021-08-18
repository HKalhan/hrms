package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.VerificationByCodeService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.verifications.VerificationByCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/verificationByCodeService")
public class VerificationByCodeServicesController {
    private VerificationByCodeService verificationByCodeService;

    @Autowired
    public VerificationByCodeServicesController(VerificationByCodeService verificationByCodeService) {
        super();
        this.verificationByCodeService = verificationByCodeService;
    }
    @PostMapping("/approve")
    public Result approve(@RequestBody VerificationByCode verificationByCode) {
        return this.verificationByCodeService.approve(verificationByCode);
    }
}
