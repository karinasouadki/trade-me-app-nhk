package com.esgi.trademe.use_cases.agence.application;

import com.esgi.trademe.kernel.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Command object
 */
@AllArgsConstructor
@Data
public final class DeleteAgence implements Command {

    private String agenceId;


}
