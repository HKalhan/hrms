package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LinkDao extends JpaRepository<Link, Integer> {
    Link getById(int id);
    List<Link> getAllByCandidate_id(int id);
}
