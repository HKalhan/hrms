package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dto.EmployerDto;

import java.util.List;
import java.util.Map;

public interface EmployerService {
    Result add(Employer employer);
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getByEmail(String email);
    DataResult<Employer> getById(int id);
    DataResult<List<EmployerDto>> getEmployerDto();

   /* DataResult<List<Employer>> getByIsAcivatedUpdate();

    Map<String, Object> getJson(Employer employer);
*/
}
