package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.FavJobAdvertService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Experience;
import com.example.hrms.entities.concretes.FavJobAdvert;
import com.example.hrms.entities.dto.JobAdvertFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/favJobAdverts")
@CrossOrigin
public class FavJobAdvertsController {

    private FavJobAdvertService favJobAdvertService;

    @Autowired
    public FavJobAdvertsController(FavJobAdvertService favJobAdvertService) {
        super();
        this.favJobAdvertService = favJobAdvertService;
    }

    @GetMapping("/getAll")
    public DataResult<List<FavJobAdvert>> getAll() {
        return this.favJobAdvertService.getAll();
    }


    @GetMapping("/add")
    public ResponseEntity<?> add(@RequestBody FavJobAdvert favJobAdvert) {
        return  ResponseEntity.ok(this.favJobAdvertService.add(favJobAdvert));
    }

    @GetMapping("/getByJobAdvertId")
    public DataResult<FavJobAdvert> getByJobAdvert_Id(int id) {
        return this.favJobAdvertService.getByJobAdvert_Id(id);
    }


    @DeleteMapping("/deleteById")
    @Transactional
    public Result deleteById(int id) {
        return this.favJobAdvertService.delete(id);
    }

}
