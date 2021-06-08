package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
    private ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService) {
        super();
        this.imageService = imageService;
    }

    @PostMapping(value="/add" )
    public ResponseEntity<?> add(@RequestParam(value="id") int id , @RequestParam(value="imageFile") MultipartFile imageFile) {

        return ResponseEntity.ok(this.imageService.upload(id,imageFile));
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam("id") int id){
        return this.imageService.delete(id);
    }

    @GetMapping("/getbyid")
    public DataResult<Image> getById(@RequestParam("id") int id){
        return this.imageService.getById(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Image>> getAll(){
        return this.imageService.getAll();
    }


    @GetMapping("/getByJobseekerId")
    public DataResult<Image> getByJobseekerId(@RequestParam int id){
        return this.imageService.getByCandidate(id);
    }
}
