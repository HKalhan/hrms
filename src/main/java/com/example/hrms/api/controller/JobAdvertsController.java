package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dto.JobAdvertDto;
import com.example.hrms.entities.dto.JobAdvertFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/jobAdverts")
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
    public DataResult<JobAdvert> getById(@RequestParam ("id" ) int id){
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

    @GetMapping("/get-approved")
    public DataResult<List<JobAdvert>> getApprovedJobAdverts() {
        return this.jobAdvertService.getApprovedJobAdverts();
    }

    @GetMapping("/get-requests")
    public DataResult<List<JobAdvert>> getJobAdvertRequests() {
        return this.jobAdvertService.getJobAdvertRequests();
    }

    @GetMapping("/approve")
    public Result approveJobAdvert(int id) {
        return this.jobAdvertService.approveJobAdvert(id);
    }

    @GetMapping("/cancel")
    public Result cancelJobAdvert(int id) {
        return this.jobAdvertService.cancelJobAdvert(id);
    }

    @PostMapping("/addDto")
    public Result add(@RequestBody JobAdvertDto jobAdvertDto) {
        System.out.println("INFO" +jobAdvertDto.toString());
        return this.jobAdvertService.create(jobAdvertDto);
    }

    @PostMapping("/getfilterandpage")
    public Result getFilterAndPage(@RequestParam int pageNo,@RequestParam int pageSize,@RequestBody JobAdvertFilter jobAdvertFilter) {
        return this.jobAdvertService.getAllFilterAndPage(pageNo, pageSize, jobAdvertFilter);

    }




}


