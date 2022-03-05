package com.esgi.trademe.use_cases.profile.domain;

import com.esgi.trademe.use_cases.agence.domain.Agence;
import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Utilisateurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Worker {
    @Id
    private String id;
    @Indexed
    private String lastname;
    private String firstname;
    @Indexed
    private String email;
    private String password;
    private Profile profile;
    @DBRef
    private Roles role;
    @DBRef
    private Agence agence;

}
