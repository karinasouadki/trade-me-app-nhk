package com.esgi.trademe.use_cases.profile.exposition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkillResponse {
    private  String id;
    private  String pays;
    private  String departement;
    private  String numeroRue;
    private  String rue;
    private  String codePostal;
    private  String ville;
}
