package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ForeignLanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ForeignLanguageDao;
import com.example.hrms.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        super();
        this.foreignLanguageDao = foreignLanguageDao;
    }


    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult("Yabancı dil bilgisi eklendi.");
    }

    @Override
    public Result update(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult("Yabancı dil bilgisi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.foreignLanguageDao.deleteById(id);
        return new SuccessResult("Yabancı dil bilgisi kaldırıldı.");
    }

    @Override
    public DataResult<ForeignLanguage> getById(int id) {
        return new SuccessDataResult<ForeignLanguage>(this.foreignLanguageDao.getById(id));
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll());
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAllByCandidateId(int id) {
        return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.getAllByCandidate_id(id));
    }
}
