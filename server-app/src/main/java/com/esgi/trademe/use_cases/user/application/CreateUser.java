package com.esgi.trademe.use_cases.user.application;

import com.esgi.trademe.kernel.Command;
import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * Command object
 */
@AllArgsConstructor
@Data
public final class CreateUser implements Command {

    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private Roles role;


}
