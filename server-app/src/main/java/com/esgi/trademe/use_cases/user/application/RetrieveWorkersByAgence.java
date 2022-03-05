package com.esgi.trademe.use_cases.user.application;


import com.esgi.trademe.kernel.Query;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Quaery object
 */
@AllArgsConstructor
@Data
public final class RetrieveWorkersByAgence implements Query {
    private final String agenceId;
}
