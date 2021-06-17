package com.example.hrms.core.utilities.verifications;

import org.springframework.stereotype.Service;

@Service
public class ValidationManager implements ValidationService {


    @Override
    public void verifyByCode(String emailAddress, String code) {
        System.out.println(code+"Code send your email :"+emailAddress);
    }


}
