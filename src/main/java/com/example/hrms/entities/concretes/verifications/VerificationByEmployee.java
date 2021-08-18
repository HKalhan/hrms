package com.example.hrms.entities.concretes.verifications;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "verification_by_employees")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class VerificationByEmployee extends Verification {

    @Column(name="entity_id")
    @NonNull
    private  int entityId;

    @Column(name = "verification_type")
    @NonNull
    private VerificationTypeEnum verificationTypeEnum;

    @Column(name="employee_id")
    private Integer employeeId;
}

