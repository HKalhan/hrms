package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @NotNull
    @Column(name = "url")
    private String url;

    @NotNull
    @Column(name = "update_date")
    private LocalDate updateDate;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    /* FetchType, aralarında ilişki bulunan entitylerden bir tarafı(candidate) yüklerken diğer tarafın(image)
     yüklenme  stratejisini belirlememize olanak sağlar.
     2 tip yükleme stratejisi var.Ben burada LAZY( Sonradan Yükleme) stratejisini kullandım.
     Ayrıca adresin isteğe bağlı değil zorunlu olduğunu optional=false ile belirttim, bu Fetch yapısının
     daha doğru çalışmasına yardım eder
     */

}
