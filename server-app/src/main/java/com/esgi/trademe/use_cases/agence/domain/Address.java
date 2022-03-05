package com.esgi.trademe.use_cases.agence.domain;

import com.esgi.trademe.kernel.ValueObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public final class Address implements ValueObject {
    private  String pays;
    private  String departement;
    private  String numeroRue;
    private  String rue;
    private  String codePostal;
    private  String ville;
}
