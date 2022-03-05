package com.esgi.trademe.use_cases.agence.exposition;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressRequest {
    @NotNull
    @NotBlank
    public  String pays;
    @NotNull
    @NotBlank
    public  String departement;
    @NotNull
    @NotBlank
    public  String numeroRue;
    @NotNull
    @NotBlank
    public  String rue;
    @NotNull
    @NotBlank
    public  String codePostal;
    @NotNull
    @NotBlank
    public  String ville;
}
