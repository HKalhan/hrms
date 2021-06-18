package com.example.hrms.entities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertDto {
    private int id;
    private int jobTitleId;
    private int cityId;
    private int employerId;
    private int salaryMin;
    private int salaryMax;
    private String jobDescription;
    private int openPositionCount;
    private LocalDate applicationDeadline;
    private boolean isActive;

}
