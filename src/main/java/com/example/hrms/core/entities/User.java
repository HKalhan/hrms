package com.example.hrms.core.entities;

import com.example.hrms.entities.concretes.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@Inheritance(strategy= InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email_address")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Column(name = "password")
    @NotNull
    @NotBlank
    private String password;


    @Column(name = "phone_number")
    private String phoneNumber;


    @OneToOne(mappedBy = "user" )
    @JsonIgnore
    private Image images;

}
