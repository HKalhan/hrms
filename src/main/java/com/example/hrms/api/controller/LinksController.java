package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.LinkService;
import com.example.hrms.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/api/links") // su name leri koymasan mı artık :D
public class LinksController {

    private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService) {
        super();
        this.linkService = linkService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Link link){
        return ResponseEntity.ok(this.linkService.add(link));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Link link){
        return ResponseEntity.ok(this.linkService.update(link));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") int id){
        return ResponseEntity.ok(this.linkService.delete(id));
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> getById(@RequestParam("id") int id){
        return ResponseEntity.ok(this.linkService.getById(id));
    }

    @GetMapping("/getAllByCandidateId")
    public ResponseEntity<?> getAllByCandidateId(@RequestParam int id){
        return ResponseEntity.ok(this.linkService.getAllByCandidateId(id));
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.linkService.getAll());
    }

}
