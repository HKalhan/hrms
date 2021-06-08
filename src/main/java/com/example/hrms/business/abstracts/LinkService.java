package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Link;

import java.util.List;

public interface LinkService {
    Result add(Link link);
    Result update(Link link);
    Result delete(int id);
    DataResult<Link> getById(int id);
    DataResult<List<Link>> getAll();
    DataResult<List<Link>> getAllByCandidateId(int id);
}
