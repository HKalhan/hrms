package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "cv_foreign_languages")
@NoArgsConstructor
@AllArgsConstructor
public class ForeignLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "language")
    private String language;

    @Min(1)
    @Max(5)
    @Column(name = "level")
    private int level;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
