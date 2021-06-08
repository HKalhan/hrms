package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.SchoolService;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    private SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        super();
        this.schoolService = schoolService;
    }

    @PostMapping( "/add")
    public ResponseEntity<?> add(@RequestBody School school) {
        return ResponseEntity.ok(this.schoolService.add(school));
    }


    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody School school){
        return ResponseEntity.ok(this.schoolService.update(school));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int id){
        return ResponseEntity.ok(this.schoolService.delete(id));
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam int id){
        return ResponseEntity.ok(this.schoolService.getById(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(this.schoolService.getAll());
    }

    @GetMapping("/getByCandidateOrderByGraduationDateDesc")
    public ResponseEntity<?> getByCandidateOrderByGraduationDateDesc(int id){

        return ResponseEntity.ok(this.schoolService.getByCandidateOrderByGraduationDateDesc(id));
    }
}
