package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDao extends JpaRepository<School, Integer> {
    School getById(int id);
    List<School> getAllByCandidate_id(int id);
    List<School> getAllByCandidate_idOrderByGraduationDateDesc(int id);
}
