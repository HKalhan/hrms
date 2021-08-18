package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.FavJobAdvert;


public interface FavJobAdvertService extends BaseService<FavJobAdvert>{

    DataResult<FavJobAdvert> getByJobAdvert_Id(int id);

    Result deleteByJobAdvertId(int id);

    Result delete(int id);

}