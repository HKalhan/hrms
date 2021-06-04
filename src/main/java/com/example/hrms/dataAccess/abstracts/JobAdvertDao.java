package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {

    JobAdvert getById(int id);

    @Query(" From JobAdvert where isActive=true")
    List<JobAdvert> getAllActiveJobAdvert();

    @Query( "From JobAdvert where isActive=true order By publishedAt Desc")
    List<JobAdvert>  findAllByOrderByPublishedAtDesc();

    @Query("From JobAdvert where isActive = true and employer_id =:id")
    List<JobAdvert> getAllActiveJobAdvertByEmployer(int id);

}
