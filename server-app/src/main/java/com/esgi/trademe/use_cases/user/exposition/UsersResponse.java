package com.esgi.trademe.use_cases.user.exposition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@SuppressWarnings("all")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersResponse {
    private List<UserResponse> users;
}
