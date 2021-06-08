package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {
    ForeignLanguage getById(int id);
    List<ForeignLanguage> getAllByCandidate_id(int id);
}
