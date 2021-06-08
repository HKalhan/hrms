package com.example.hrms.api.controller;


import com.example.hrms.business.abstracts.ForeignLanguageService;
import com.example.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/foreignLanguages")
public class ForeignLanguagesController {

    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
        super();
        this.foreignLanguageService = foreignLanguageService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ForeignLanguage foreignLanguage )
    {
        return ResponseEntity.ok(this.foreignLanguageService.add(foreignLanguage));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ForeignLanguage foreignLanguage){
        return ResponseEntity.ok(this.foreignLanguageService.update(foreignLanguage));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return ResponseEntity.ok(this.foreignLanguageService.delete(id));
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(this.foreignLanguageService.getById(id));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.foreignLanguageService.getAll());
    }


}
