package com.esgi.trademe.use_cases.agence.exposition;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AgenceRequest {
    @NotNull
    @NotBlank
    public String cost;
    @NotNull
    @NotBlank
    public String libelle;
    @NotNull
    @NotBlank
    public AddressRequest adresse;
}
