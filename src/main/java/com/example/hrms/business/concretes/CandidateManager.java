package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.entities.concretes.Candidate;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private UserService userService;
    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserService userService) {
        super();
        this.candidateDao = candidateDao;
        this.userService=userService;
    }

    @Override
    public Result add(Candidate candidate) {
        if ((this.userService.checkEmail(candidate.getEmail()).getData() ==null) &&
                (this.checkIdIsExist(candidate.getIdentificationNumber()).getData() == null)) {
            this.candidateDao.save(candidate);
            return  new SuccessResult(" iş arayan eklendi");
        }
        this.candidateDao.save(candidate);
        return  new ErrorResult("Daha önce kayıtlı bir e-posta veya tcno var ise kayıt gerçekleşmez");
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "İş arayanlar listelendi.");
    }


    private DataResult<Candidate> checkIdIsExist (String identificationNumber ){
        return new SuccessDataResult<Candidate>(this.candidateDao.findByIdentificationNumber(identificationNumber));
    }
}
