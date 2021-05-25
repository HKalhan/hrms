package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/job-titles")
public class JobTitlesController {

    private JobTitleService jobTitleService;

    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("getall")
    public List<JobTitle> getAll() {
        return this.jobTitleService.getAll();
    }
}
