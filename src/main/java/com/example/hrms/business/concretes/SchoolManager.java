package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.SchoolService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.SchoolDao;
import com.example.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
     private SchoolDao schoolDao;

     @Autowired
    public SchoolManager(SchoolDao schoolDao) {
         super();
        this.schoolDao = schoolDao;
    }


    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("Okul bilgisi eklendi.");
    }

    @Override
    public SuccessResult update(School school) {
         this.schoolDao.save(school);
        return new SuccessResult("Okul bilgileri güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.schoolDao.deleteById(id);
        return new SuccessResult("Okul bilgileri silindi.");
    }

    @Override
    public DataResult<School> getById(int id) {
        return new SuccessDataResult<School>(this.schoolDao.getById(id));
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
    }

    @Override
    public DataResult<List<School>> getAllByCandidateId(int id) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCandidate_id(id));
    }

    @Override
    public DataResult<List<School>> getByCandidateOrderByGraduationDateDesc(int id) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getAllByCandidate_idOrderByGraduationDateDesc(id));
    }
}
