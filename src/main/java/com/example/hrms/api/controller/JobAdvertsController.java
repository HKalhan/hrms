package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvert")
public class JobAdvertsController {

    private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertsController(JobAdvertService jobAdvertService) {
        super();
        this.jobAdvertService = jobAdvertService;
    }

    @PostMapping("/add")

    public Result add(@RequestBody JobAdvert jobAdvert){
        return this.jobAdvertService.add(jobAdvert);
    }

    @GetMapping("/getById")
    public DataResult<JobAdvert> getById(@RequestParam int id){
        return this.jobAdvertService.getById(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvert>> getAll(){
        return this.jobAdvertService.getAll();
    }

    @GetMapping("/getAllSortedByDate")
    public DataResult<List<JobAdvert>> getAllSortedByDate() {
        return this.jobAdvertService.getAllSortedByDate();
    }

    @GetMapping("/getAllActiveJobAdvert")
    public DataResult<List<JobAdvert>> getAllActiveJobAdvert(){
        return this.jobAdvertService.getAllActiveJobAdvert();
    }

    @GetMapping("/findAll")
    public DataResult<List<JobAdvert>> findAll(){
        return this.jobAdvertService.findAllByOrderByPublishedAtDesc();
    }

    @GetMapping("/getAllActiveJobAdvertByEmployer")
    public DataResult<List<JobAdvert>> getAllActiveJobAdvertByEmployer(@RequestParam int id){
        return this.jobAdvertService.getAllActiveJobAdvertByEmployer(id);
    }

    @PostMapping("/changeOpenToClose")
    public Result changeOpenToClose(@RequestParam int id){
        return this.jobAdvertService.changeOpenToClose(id);
    }
}


