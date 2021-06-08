package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
    List<JobTitle> getByTitle(String title);
}
