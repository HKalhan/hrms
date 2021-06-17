package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
    Candidate getByEmail(String email);
    Candidate getById(int id);
    Candidate getByIdentificationNumber(String identificationNumber);
}
