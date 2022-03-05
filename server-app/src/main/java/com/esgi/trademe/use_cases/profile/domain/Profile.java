package com.esgi.trademe.use_cases.profile.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Profile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    private String id;
    @DBRef
    private Worker worker;
    private Double tjm;
    private String geographicalArea;
    private List<Skill> skills;
    private List<Certificate> certificates;
    private String statut;

}
