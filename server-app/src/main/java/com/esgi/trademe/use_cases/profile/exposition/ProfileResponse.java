package com.esgi.trademe.use_cases.profile.exposition;

import com.esgi.trademe.use_cases.profession.domain.Profession;
import com.esgi.trademe.use_cases.user.exposition.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProfileResponse {
    private String id;
    private UserResponse user;
    private Profession profession;
    public Double tjm;
    public String geographicalArea;
    public List<SkillResponse> skills;
    public List<CertificateResponse> certificates;
}