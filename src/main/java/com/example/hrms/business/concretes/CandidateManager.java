package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.*;
import com.example.hrms.core.utilities.adapters.MernisService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.dto.CVDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private UserService userService;
    private MernisService mernisService;
    private ImageService imageService;
    private CoverLetterService coverLetterService;
    private ExperienceService experienceService;
    private SchoolService schoolService;
    private ForeignLanguageService foreignLanguageService;
    private ProgrammingAbilityService programmingAbilityService;
    private LinkService linkService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, UserService userService, MernisService mernisService, ImageService imageService,
                            CoverLetterService coverLetterService, ExperienceService experienceService, SchoolService schoolService,
                            ForeignLanguageService foreignLanguageService, ProgrammingAbilityService programmingAbilityService,
                            LinkService linkService) {
        super();
        this.candidateDao = candidateDao;
        this.userService=userService;
        this.mernisService=mernisService;
        this.imageService=imageService;
        this.coverLetterService=coverLetterService;
        this.experienceService=experienceService;
        this.schoolService=schoolService;
        this.foreignLanguageService=foreignLanguageService;
        this.programmingAbilityService=programmingAbilityService;
        this.linkService=linkService;

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

    @Override
    public DataResult<CVDto> getCv(int candidateId) {
        CVDto cv =new CVDto();
        cv.setCandidate(this.getById(candidateId).getData());
        cv.setCoverLetters(this.coverLetterService.getByCandidate_id(candidateId).getData());
        cv.setExperiences(this.experienceService.getAllByCandidate_idOrderByLeaveDateDesc(candidateId).getData());
        cv.setForeignLanguages(this.foreignLanguageService.getAllByCandidateId(candidateId).getData());
        cv.setImage(this.imageService.getByUser(candidateId).getData());
        cv.setLinks(this.linkService.getAllByCandidateId(candidateId).getData());
        cv.setProgrammingAbilities(this.programmingAbilityService.getAllByCandidateId(candidateId).getData());
        cv.setSchools(this.schoolService.getByCandidateOrderByGraduationDateDesc(candidateId).getData());

        return new SuccessDataResult<CVDto>(cv);
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
