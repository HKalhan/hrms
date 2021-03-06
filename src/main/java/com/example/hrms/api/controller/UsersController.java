package com.example.hrms.api.controller;


import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.entities.User;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorDataResult;
import com.example.hrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;
    private ImageService imageService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    @PostMapping("/api/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }

    @GetMapping("/getbyid")
    public DataResult<User> getById(int id) {
        return this.userService.getById(id);
    }



    @PostMapping("/upload-image")
    public Result uploadImage(int userId, MultipartFile file) {
        return this.imageService.upload(userId, file);
    }
}
