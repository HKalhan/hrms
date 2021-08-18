package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ExperienceDao;
import com.example.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        super();
        this.experienceDao = experienceDao;
    }


    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("Deneyim bilgileriniz eklendi.");
    }

    @Override
    public Result update(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("Deneyim bilgileriniz güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.experienceDao.deleteById(id);
        return new SuccessResult("Deneyim bilgileriniz kaldırıldı.");
    }

    @Override
    public DataResult<Experience> getById(int id) {
        return new SuccessDataResult<Experience>(this.experienceDao.getById(id));
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
    }

    @Override
    public DataResult<List<Experience>> getAllByCandidate_idOrderByLeaveDateDesc(int id) {
        return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByCandidate_userIdOrderByLeaveDateDesc(id));
    }

    @Override
    public DataResult<List<Experience>> getAllByCandidate_id(int id) {
        return new SuccessDataResult<List<Experience>>(this.experienceDao.getAllByCandidate_userId(id));
    }
}
