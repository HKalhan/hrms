package com.example.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "verifications_by_codes")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationByCode  extends Verification{

    @Column(name = "user_id")
    private int userId;

    @Column(name = "code")
    private String code;

}
