package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.ExperienceService;
import com.example.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

    private ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        super();
        this.experienceService = experienceService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Experience experience )
    {
        return ResponseEntity.ok(this.experienceService.add(experience));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Experience experience){
        return ResponseEntity.ok(this.experienceService.update(experience));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return ResponseEntity.ok(this.experienceService.delete(id));
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id){
        return ResponseEntity.ok(this.experienceService.getById(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(this.experienceService.getAll());
    }

    @GetMapping("/getAllByCandidate_idOrderByLeaveDateDesc")
    public ResponseEntity<?> getAllByCandidate_idOrderByLeaveDateDesc(@RequestParam("id") int id){
        return ResponseEntity.ok(this.experienceService.getAllByCandidate_idOrderByLeaveDateDesc(id));
    }

    @GetMapping("/getAllByCandidateId")
    public ResponseEntity<?> getAllByCandidateId(@RequestParam int id){
        return ResponseEntity.ok(this.experienceService.getAllByCandidate_id(id));
    }
}
