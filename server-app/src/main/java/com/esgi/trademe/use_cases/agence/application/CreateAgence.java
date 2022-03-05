package com.esgi.trademe.use_cases.agence.application;

import com.esgi.trademe.kernel.Command;
import com.esgi.trademe.use_cases.agence.exposition.AddressRequest;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Command object
 */
@AllArgsConstructor
@Data
public final class CreateAgence implements Command {

    private String cost;
    private String libelle;
    private AddressRequest adresse;

}
