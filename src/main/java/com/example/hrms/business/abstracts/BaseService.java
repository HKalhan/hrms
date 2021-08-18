package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;

import java.util.List;

public interface BaseService<T> {

    public DataResult<List<T>> getAll();
    public Result add(T entity);
}
