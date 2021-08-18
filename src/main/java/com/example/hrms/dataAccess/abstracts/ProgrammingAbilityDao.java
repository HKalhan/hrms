package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.ProgrammingAbility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingAbilityDao extends JpaRepository<ProgrammingAbility , Integer> {
    ProgrammingAbility getById(int id);
    List<ProgrammingAbility> getAllByCandidate_userId(int userId);
}
