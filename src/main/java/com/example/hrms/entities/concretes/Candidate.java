package com.example.hrms.entities.concretes;

import com.example.hrms.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Candidate extends User {

    public Candidate(int user_id) {
        this.setUserId(user_id);
    }


    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @NotBlank
    @Column(name = "identification_number")
    private String identificationNumber;

    @NotNull
    @Column(name = "birth_date", columnDefinition = "Date default CURRENT_DATE")
    private LocalDate birthDate;


    @Column(name = "github_address", columnDefinition = "TEXT")
    String githubAddress;

    @Column(name = "linkedin_address", columnDefinition = "TEXT")
    String linkedinAddress;


    @OneToMany(mappedBy = "candidate")
    @JsonIgnore //JSON verisinde gözükmesi istenmeyen anahtarlar özel olarak belirtmek istenirse kullanılır.
    private List<CoverLetter> coverLetters;


    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<Experience> experiences;


    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<ForeignLanguage> foreignLanguages;


    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<Link> links;


    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<ProgrammingAbility> programmingAbilities;


    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<School> schools;


    @OneToMany(mappedBy = "candidate")
    private List<FavJobAdvert> favJobAdvert;


    /*@OneToOne(mappedBy = "candidate" )
    @JsonIgnore
    private Image images;*/
}

