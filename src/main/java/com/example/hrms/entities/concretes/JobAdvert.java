package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_adverts")
public class JobAdvert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "salary_min")
    private int salaryMin;

    @Column(name = "salary_max")
    private int salaryMax;

    @Column(name = "open_position_count")
    private int openPositionCount;

    @Column(name="application_date")
    private LocalDate applicationDate;

    @Column(name="application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "published_at")
    private LocalDate publishedAt;

    @Column(name= "is_active")
    private boolean isActive;

}