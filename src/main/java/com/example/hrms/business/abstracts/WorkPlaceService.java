package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.WorkPlace;

import java.util.List;

public interface WorkPlaceService {
    DataResult<List<WorkPlace>> getAll();
    DataResult<WorkPlace> getById(int id);
}
