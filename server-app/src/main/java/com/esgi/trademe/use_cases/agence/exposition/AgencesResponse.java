package com.esgi.trademe.use_cases.agence.exposition;

import com.esgi.trademe.use_cases.user.exposition.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@SuppressWarnings("all")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgencesResponse {
    private List<AgenceResponse> agences;
}
