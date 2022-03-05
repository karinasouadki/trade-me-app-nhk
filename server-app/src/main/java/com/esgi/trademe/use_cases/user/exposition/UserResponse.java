package com.esgi.trademe.use_cases.user.exposition;

import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@SuppressWarnings("all")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private String id;
    private String lastname;
    private String firstname;
    private String email;
    private String password;
    private Roles role;
    private AgenceResponse agence;
    private Boolean isDeleted;
    private String token;
    private Date expiryDate;
    private Date connectedAt;
    private Date dateStart;
    private Date dateEnd;
}
