package com.esgi.trademe.use_cases.user.application;

import com.esgi.trademe.kernel.Command;
import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Command object
 */
@AllArgsConstructor
@Data
public final class DeleteWorker implements Command {

    private String userId;


}
