package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.adapters.MernisService;
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
    private MernisService mernisService;
    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserService userService) {
        super();
        this.candidateDao = candidateDao;
        this.userService=userService;
    }

    @Override
    public Result add(Candidate candidate) {
        if (this.checkIdIsExist(candidate.getIdentificationNumber()).getData() != null) {
            return  new ErrorResult(candidate.getIdentificationNumber()+" already exist");
        }

        if (this.checkMernisVerification(candidate.getIdentificationNumber(),candidate.getFirstName()
                ,candidate.getLastName(),candidate.getBirthDate().getYear())==false)
        {
            return new ErrorDataResult<Candidate>("Authentication is incorrect");
        }


        this.candidateDao.save(candidate);
        return  new SuccessResult(" Candidate added");

    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "candidate listed.");
    }

    @Override
    public DataResult<Candidate> getByEmail(String email) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getByEmail(email));
    }

    @Override
    public DataResult<Candidate> getByIdentificationNumber(String identificationNumber) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentificationNumber(identificationNumber));
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
    }


    private DataResult<Candidate> checkIdIsExist (String identificationNumber ){
        return new SuccessDataResult<Candidate>(this.candidateDao.getByIdentificationNumber(identificationNumber));
    }

    private boolean checkMernisVerification(String identificationNumber, String firstName, String lastName, int birthDate) {
        if (mernisService.checkIfRealPerson(identificationNumber,firstName,lastName,birthDate)){
            return true; }
        return false;
    }
}
