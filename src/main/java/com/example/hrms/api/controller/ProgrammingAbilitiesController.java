package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.ProgrammingAbilityService;
import com.example.hrms.entities.concretes.ProgrammingAbility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/programmingabilities")
public class ProgrammingAbilitiesController {

    private ProgrammingAbilityService programmingAbilityService;

    @Autowired
    public ProgrammingAbilitiesController(ProgrammingAbilityService programmingAbilityService) {
        super();
        this.programmingAbilityService = programmingAbilityService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ProgrammingAbility programmingAbility){
        return ResponseEntity.ok(this.programmingAbilityService.add(programmingAbility));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ProgrammingAbility programmingAbility){
        return ResponseEntity.ok(this.programmingAbilityService.update(programmingAbility));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return ResponseEntity.ok(this.programmingAbilityService.delete(id));
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(this.programmingAbilityService.getById(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(this.programmingAbilityService.getAll());
    }
    @GetMapping("/getallbycandidate")
    public ResponseEntity<?> getAllByCandidateId(int id){
        return ResponseEntity.ok(this.programmingAbilityService.getAllByCandidateId(id));
    }

}
