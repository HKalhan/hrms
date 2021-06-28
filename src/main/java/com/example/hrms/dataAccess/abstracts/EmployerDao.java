package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.business.abstracts.CoverLetterService;
import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.dto.EmployerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    List<Employer> getByCompanyName(String companyName);
    List<Employer> getByWebAddress(String webAddress);
    Employer getByEmail(String email);


}
