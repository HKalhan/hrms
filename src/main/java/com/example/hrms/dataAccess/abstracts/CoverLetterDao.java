package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {
    List<CoverLetter> getByCandidate_userId(int userId);
}
