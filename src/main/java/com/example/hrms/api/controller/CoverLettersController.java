package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.CoverLetterService;
import com.example.hrms.dataAccess.abstracts.CoverLetterDao;
import com.example.hrms.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coverLetters")
public class CoverLettersController {

    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService) {
        super();
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CoverLetter coverLetter )
    {
        return ResponseEntity.ok(this.coverLetterService.add(coverLetter));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody CoverLetter coverLetter){
        return ResponseEntity.ok(this.coverLetterService.update(coverLetter));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return ResponseEntity.ok(this.coverLetterService.delete(id));
    }

    @GetMapping("/getbycandidateId")
    public ResponseEntity<?> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(this.coverLetterService.getByCandidate_id(id));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(this.coverLetterService.getAll());
    }

}
