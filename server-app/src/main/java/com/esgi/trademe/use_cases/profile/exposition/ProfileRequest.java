package com.esgi.trademe.use_cases.profile.exposition;


import com.esgi.trademe.use_cases.profession.domain.Profession;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ProfileRequest {

    @NotNull
    @NotBlank
    public Profession profession;
    @NotNull
    @NotBlank
    public Double tjm;
    @NotNull
    @NotBlank
    public String geographicalArea;
    public List<SkillResponse> skills;
    public List<CertificateResponse> certificates;
}
