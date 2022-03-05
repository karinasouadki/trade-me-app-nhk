package com.esgi.trademe.use_cases.agence.application;

import com.esgi.trademe.kernel.Query;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Quaery object
 */
@AllArgsConstructor
@Data
public final class RetrieveAgence implements Query {
    private String id;
}
