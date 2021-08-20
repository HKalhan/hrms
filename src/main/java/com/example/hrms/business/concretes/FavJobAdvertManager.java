package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.FavJobAdvertService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.FavJobAdvertDao;
import com.example.hrms.entities.concretes.FavJobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavJobAdvertManager implements FavJobAdvertService {

    private FavJobAdvertDao favJobAdvertDao;
    @Autowired
    public FavJobAdvertManager(FavJobAdvertDao favJobAdvertDao) {
        this.favJobAdvertDao = favJobAdvertDao;
    }

    @Override
    public DataResult<List<FavJobAdvert>> getAll() {
        return new SuccessDataResult<List<FavJobAdvert>>
                (this.favJobAdvertDao.findAll(), "Favorite job adverts listed");
    }

    @Override
    public Result add(FavJobAdvert entity) {
        this.favJobAdvertDao.save(entity);
        return new SuccessResult("Job advert added to favorites!");
    }



    @Override
    public DataResult<FavJobAdvert> getByJobAdvert_Id(int id) {

        return new SuccessDataResult<FavJobAdvert>
                (this.favJobAdvertDao.getByJobAdvert_Id(id), "");
    }

    @Override
    public Result deleteByJobAdvertId(int id) {
        this.favJobAdvertDao.deleteByJobAdvert_Id(id);
        return new SuccessResult("Job Advert deleted to favorites");
    }

    @Override
    public Result delete(int id) {
        this.favJobAdvertDao.deleteById(id);
        return new SuccessResult("Favorilerden çıkarıldı");
    }


}
