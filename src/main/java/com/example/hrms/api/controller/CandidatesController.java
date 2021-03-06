package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
    private CandidateService candidateService;
    @Autowired
    public CandidatesController(CandidateService candidateService) {
       super();
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }
    @PostMapping("/add")


    public ResponseEntity<?> add (@Valid @RequestBody Candidate candidate){

        return ResponseEntity.ok(this.candidateService.add(candidate));
    }

    @GetMapping("/cv")
    public ResponseEntity<?> getCv(@RequestParam int candidateId){
        return ResponseEntity.ok(this.candidateService.getCv(candidateId));
    }

}
