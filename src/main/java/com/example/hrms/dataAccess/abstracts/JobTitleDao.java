package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

}
