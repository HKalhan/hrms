package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.*;
import com.example.hrms.core.business.BusinessRules;
import com.example.hrms.core.utilities.verifications.CodeGenerator;
import com.example.hrms.core.utilities.verifications.ValidationManager;
import com.example.hrms.core.utilities.verifications.ValidationService;
import com.example.hrms.core.utilities.adapters.MernisService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.VerificationByCode;
import com.example.hrms.entities.concretes.VerificationByEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    private MernisService mernisService;
    private CandidateService candidateService;
    private EmployerService employerService;
    private ValidationService validationService;
    private VerificationByCodeService verificationByCodeService;
    private VerificationByEmployeeService verificationByEmployeeService;
    private UserService userService;

    @Autowired
    public AuthManager(MernisService mernisService, CandidateService candidateService, EmployerService employerService,
                       ValidationService validationService, VerificationByCodeService verificationByCodeService,
                       VerificationByEmployeeService verificationByEmployeeService, UserService userService) {
        super();
        this.mernisService = mernisService;
        this.candidateService = candidateService;
        this.employerService = employerService;
        this.validationService = validationService;
       this.verificationByCodeService=verificationByCodeService;
       this.verificationByEmployeeService=verificationByEmployeeService;
       this.userService=userService;
    }

    @Override
    public Result registerCandidate(Candidate candidate , String confirmPassword) {

        var result =BusinessRules.run(this.checkEqualpassword(candidate.getPassword(), confirmPassword),
                this.userEmailExist(candidate.getEmail()));
        if (result != null) {
            return result;
        }

        var addCandidate = this.candidateService.add(candidate);

        if(!addCandidate.isSuccess()) {

            return new ErrorResult("Candidate not registered.");
        }

       var code= CodeGenerator.sendVerificationCode();
        VerificationByCode verifyCodeEntity = new VerificationByCode(candidate.getId(), code);
        this.verificationByCodeService.add(verifyCodeEntity);
        this.validationService.verifyByCode(candidate.getEmail(), code);
       return new SuccessResult();

    }

    @Override
    public Result registerEmployer(Employer employer, String confirmPassword) {
        var result= BusinessRules.run(this.checkEmailMatch(employer),this.checkEqualpassword(confirmPassword,
                employer.getPassword()), this.userEmailExist(employer.getEmail()));
        if (result!=null){
            return result;
        }

        var add= this.employerService.add(employer);

        if (!add.isSuccess()) {
            return new ErrorResult("Employer information is incorrect.");
        }

        var code= CodeGenerator.sendVerificationCode();
        VerificationByCode verificationByCode=new VerificationByCode(employer.getId(), code);
        VerificationByEmployee verificationByEmployee=new VerificationByEmployee(employer.getId(), null);
        this.verificationByCodeService.add(verificationByCode);
        this.verificationByEmployeeService.add(verificationByEmployee);
        this.validationService.verifyByCode(employer.getEmail(), code);

        return new SuccessResult();
    }




    private Result checkEqualpassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return new SuccessResult();
        }
        return new ErrorResult("Password does not match. Please re-enter your password.");
    }


    private Result userEmailExist(String email) {
        if (this.userService.checkEmail(email).getData() == null)
        {
            return new SuccessResult();
        }
        return new ErrorResult();
    }




    public Result checkEmailMatch(Employer employer) {
        var mailDomain = employer.getEmail().split("@")[1];
        return mailDomain.equals(employer.getWebAddress()) ? new SuccessResult() :
                new ErrorResult("E-mail domain and web address does not match.");
    }


}


