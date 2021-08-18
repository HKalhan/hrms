package com.example.hrms.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertFilter {
    private List<Integer> cityId;
    private List<Integer> jobTitleId;
    private List<Integer> workPlaceId;
    private List<Integer> workTimeId;

}
