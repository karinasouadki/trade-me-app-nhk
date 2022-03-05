package com.esgi.trademe.use_cases.subscription.application;


import com.esgi.trademe.kernel.Command;
import com.esgi.trademe.use_cases.subscription.domain.Subscription;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Command object
 */
@AllArgsConstructor
@Data
public final class Payment implements Command {
    private Subscription subscription;
}
