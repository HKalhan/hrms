package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dto.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }



    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Employer employer) {
        this.employerService.add(employer);
    }

    @GetMapping("/getById")
    public DataResult<Employer> getById(@RequestParam("id") int id){
        return this.employerService.getById(id);
    }



    @GetMapping("/getEmployerDto")
    public DataResult<List<EmployerDto>> getEmployerDto(){
        return this.employerService.getEmployerDto();
    }
}
