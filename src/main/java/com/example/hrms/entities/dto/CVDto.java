package com.example.hrms.entities.dto;

import com.example.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CVDto {
    private Candidate candidate;
    private Image image;
    private List<CoverLetter> coverLetters;
    private List<Experience> experiences;
    private List<ForeignLanguage> foreignLanguages;
    private List<Link> links;
    private List<ProgrammingAbility> programmingAbilities;
    private List<School> schools;

}
