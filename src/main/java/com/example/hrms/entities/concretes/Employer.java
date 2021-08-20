package com.example.hrms.entities.concretes;

import com.example.hrms.core.entities.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;


import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) //daha verimli derleme aşaması sağladı. neredeyse sabit bir dil ss
public class Employer extends User {
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String webAddress;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> jobAdverts;

    @Column(name = "description")
    private String description;

    @Column(name = "is_activated")
    private boolean isActivated;

    @Column(name="history")
    @Type(type="jsonb")
    private Map<String, Object> history; //??yaptığın güncellemeler onaylanana kadar girilen datalar bu fieldda tutalacak
    //onaylandığında data mevcut tabloda ki verilerle güncellenicek
    // HİSTORY fieldı daha sonra boşaltılacak ( AS GARBAGE COLLECTOR ) .

}
