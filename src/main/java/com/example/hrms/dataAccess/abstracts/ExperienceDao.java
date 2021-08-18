package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {
    Experience getById(int id);
    List<Experience> getAllByCandidate_userIdOrderByLeaveDateDesc(int userId);
    List<Experience> getAllByCandidate_userId(int userId);
}
