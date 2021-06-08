package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ProgrammingAbilityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ProgrammingAbilityDao;
import com.example.hrms.entities.concretes.ProgrammingAbility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingAbilityManager implements ProgrammingAbilityService {

    private ProgrammingAbilityDao programmingAbilityDao;

    @Autowired
    public ProgrammingAbilityManager(ProgrammingAbilityDao programmingAbilityDao) {
        super();
        this.programmingAbilityDao = programmingAbilityDao;
    }


    @Override
    public Result add(ProgrammingAbility programmingAbility) {
        this.programmingAbilityDao.save(programmingAbility);
        return new SuccessResult("programlama yeteneği kaydedildi");
    }

    @Override
    public Result update(ProgrammingAbility programmingAbility) {
        this.programmingAbilityDao.save(programmingAbility);
        return new SuccessResult("programlama yeteneği güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.programmingAbilityDao.deleteById(id);
        return new SuccessResult("programlama yeteneği kaldırıldı");
    }

    @Override
    public DataResult<ProgrammingAbility> getById(int id) {
        return new SuccessDataResult<ProgrammingAbility>(this.programmingAbilityDao.getById(id));
    }

    @Override
    public DataResult<List<ProgrammingAbility>> getAll() {
        return new SuccessDataResult<List<ProgrammingAbility>>(this.programmingAbilityDao.findAll());
    }

    @Override
    public DataResult<List<ProgrammingAbility>> getAllByCandidateId(int id) {
        return new SuccessDataResult<List<ProgrammingAbility>>(this.programmingAbilityDao.getAllByCandidate_id(id));
    }
}
