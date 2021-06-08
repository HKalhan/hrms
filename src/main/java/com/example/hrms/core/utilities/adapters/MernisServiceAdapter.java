package com.example.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements MernisService {

    @Override
    public boolean checkIfRealPerson(String identificationNumber, String firstName, String lastName, int birthDate) {

        return true;
      }

}

