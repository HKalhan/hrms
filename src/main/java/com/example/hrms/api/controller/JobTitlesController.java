package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.core.DataResult;
import com.example.hrms.core.Result;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-titles")
public class JobTitlesController {

    private JobTitleService jobTitleService;

    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobTitle>> getAll() {
        return this.jobTitleService.getAll();
    }

    @PostMapping ("/add")
    public Result add(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.add(jobTitle);
    }
}
