package com.example.hrms.core.adapters;

import com.example.hrms.entities.concretes.Candidate;

import java.util.Date;


public interface MernisService {
    boolean checkIfRealPerson(String identificationNumber, String firstName, String lastName, Date birthDate);

}
