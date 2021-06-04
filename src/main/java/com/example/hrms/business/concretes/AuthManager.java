package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.*;
import com.example.hrms.core.verifications.VerificationService;
import com.example.hrms.core.adapters.MernisService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
@Service
public class AuthManager implements AuthService {
    private MernisService mernisService;
    private CandidateService candidateService;
    private EmployerService employerService;
    private VerificationService verificationService;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public AuthManager(MernisService mernisService, CandidateService candidateService, EmployerService employerService,
                       VerificationService verificationService, VerificationCodeService verificationCodeService) {
        super();
        this.mernisService = mernisService;
        this.candidateService = candidateService;
        this.employerService = employerService;
        this.verificationService = verificationService;
       this.verificationCodeService=verificationCodeService;
    }

    @Override
    public DataResult<Candidate> registerCandidate(Candidate candidate , String confirmPassword) {
      if (this.checkMernisVerification(candidate.getIdentificationNumber(),candidate.getFirstName()
        ,candidate.getLastName(),candidate.getBirthDate().getYear())==false)
       {
            return new ErrorDataResult<Candidate>("Kimlik doğrulaması hatalı");
       }

      if (!isEmailValidation(candidate.getEmail())){
            return new ErrorDataResult<Candidate>("lütfen doğru email adresi ile giriş yapın");
      }
        if (this.checkEqualpassword(candidate.getPassword(), confirmPassword).isSuccess()) {
            this.candidateService.add(candidate);
           //this.verificationCodeService.add(candidate.getId());
           this.verificationService.verifyByCode(candidate.getEmail(), this.verificationCodeService.createCode());
            return new SuccessDataResult<Candidate>("Kayıt işlemi gerçekleşti");
        }
        return new ErrorDataResult<Candidate>("Kayıt işlemi başarısız");
        }

    @Override
    public DataResult<Employer> registerEmployer(Employer employer, String confirmPassword) {
        if(!isEmailValidation(employer.getEmail()))
        {
            return new ErrorDataResult<Employer>("lütfen doğru email adresi ile giriş yapın");
        }


        if (this.checkEqualpassword(employer.getPassword(), confirmPassword).isSuccess()) {
            this.employerService.add(employer);
            this.verificationService.verifyByEmployee(employer.getId());
            return new SuccessDataResult<Employer>("Kayıt işlemi gerçekleşti");
        }
        return new ErrorDataResult<Employer>("Kayıt işlemi başarısız");
    }



    private Result checkEqualpassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return new SuccessResult("Şifre eşleşti");
        }
        return new ErrorResult("Şifre eşleşmiyor");
    }


    private boolean checkMernisVerification(String identificationNumber, String firstName, String lastName, int birthDate) {
        if (mernisService.checkIfRealPerson(identificationNumber,firstName,lastName,birthDate)){
            return true; }
        return false;
        }

    public static boolean isEmailValidation(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }


}


