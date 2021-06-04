package com.example.hrms.core.adapters;

import com.example.hrms.entities.concretes.Candidate;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.Date;

@Service
public class MernisServiceAdapter implements MernisService {

    @Override
    public boolean checkIfRealPerson(String identificationNumber, String firstName, String lastName, int birthDate) {

        return true;
      }

}

