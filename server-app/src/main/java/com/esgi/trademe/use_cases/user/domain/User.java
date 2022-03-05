package com.esgi.trademe.use_cases.user.domain;

import com.esgi.trademe.use_cases.agence.domain.Agence;
import com.esgi.trademe.use_cases.profile.domain.Profile;
import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document(collection = "Utilisateurs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class User {
    @Id
    private String id;
    @Indexed
    private String lastname;
    private String firstname;
    @Indexed
    private String email;
    private String password;
    private Profile profile;
    private Roles role;
    @DBRef
    private Agence agence;
    private Boolean isDeleted;
    private String token;
    private Date expiryDate;
    private Date connectedAt;
    private Date dateStart;
    private Date dateEnd;

}
