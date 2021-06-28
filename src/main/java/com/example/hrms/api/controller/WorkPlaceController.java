package com.example.hrms.api.controller;

import com.example.hrms.business.abstracts.WorkPlaceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.WorkPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/workPlaces")
@CrossOrigin
public class WorkPlaceController {

    private WorkPlaceService workPlaceService;

    @Autowired
    public WorkPlaceController(WorkPlaceService workPlaceService) {
       super();
        this.workPlaceService = workPlaceService;
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkPlace>> getAll(){
        return this.workPlaceService.getAll();
    }


}
