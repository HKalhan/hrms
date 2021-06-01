package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    private AuthService authService;



    @PostMapping("/registerEmployer")
    public Result add(@RequestBody Employer employer, String confirmPassword) {
        return this.authService.registerEmployer(employer, confirmPassword);
    }

    @PostMapping("/registerCandidate")
    public Result add(@RequestBody Candidate candidate, String confirmPassword) {
        return this.authService.registerCandidate(candidate, confirmPassword);
    }

}
