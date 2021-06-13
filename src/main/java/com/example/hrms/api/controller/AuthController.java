package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }


    @PostMapping("/registerEmployer")
    public Result add(@RequestBody Employer employer, String confirmPassword) {
        return this.authService.registerEmployer(employer, confirmPassword);
    }

    @PostMapping("/registerCandidate")
    public Result add(@RequestBody Candidate candidate, String confirmPassword) {
        return this.authService.registerCandidate(candidate,confirmPassword );
    }

}
