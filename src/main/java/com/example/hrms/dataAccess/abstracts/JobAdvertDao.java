package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.core.utilities.helpers.JobAdvertFilterOption;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dto.JobAdvertFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer> {

    JobAdvert getById(int id);

    @Query(" From JobAdvert where isActive=true")
    List<JobAdvert> getAllActiveJobAdvert();

    @Query( "From JobAdvert where isActive=true order By publishedAt Desc")
    List<JobAdvert>  findAllByOrderByPublishedAtDesc();

   @Query("From JobAdvert where isActive = true and employer_id =:id")
    List<JobAdvert> getAllActiveJobAdvertByEmployer(int id);


    @Modifying
    @Query("Update JobAdvert ja set ja.isActive = :active where ja.id = :id")
    public void updateIsActive(@Param(value = "id") int id, @Param(value = "active") boolean isActive);



   @Query("Select j  from JobAdvert j where ((:#{#filter.cityId}) IS NULL OR j.city.id IN (:#{#filter.cityId}))"
            + "and ((:#{#filter.jobTitleId}) IS NULL OR j.jobTitle.jobTitleId IN (:#{#filter.jobTitleId}))"
            +" and ((:#{#filter.workPlaceId}) IS NULL OR j.workPlace.id IN (:#{#filter.workPlaceId}))"
            +" and ((:#{#filter.workTimeId}) IS NULL OR j.workTime.id IN (:#{#filter.workTimeId}))"
            + "and j.isActive = true Order By j.applicationDate Desc ")
    public Page<JobAdvert> getByFilter(@Param("filter") JobAdvertFilter jobAdvertFilter, Pageable pageable);






}


