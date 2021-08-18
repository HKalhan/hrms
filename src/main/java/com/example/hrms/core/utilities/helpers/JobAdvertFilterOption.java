package com.example.hrms.core.utilities.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertFilterOption {

    private List<Integer> cityId;
    private List<Integer> jobTitleId;
    private List<Integer> workPlaceId;
    private List<Integer> workTimeId;
    private int userIdForFavorite;
}
