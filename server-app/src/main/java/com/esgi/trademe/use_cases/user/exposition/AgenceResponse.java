package com.esgi.trademe.use_cases.user.exposition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgenceResponse {
    private String id;
    private String cost;
    private String libelle;
    private AddressResponse adresse;
}
