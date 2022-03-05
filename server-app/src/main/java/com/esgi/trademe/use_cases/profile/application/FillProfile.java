package com.esgi.trademe.use_cases.profile.application;

import com.esgi.trademe.kernel.Command;
import com.esgi.trademe.use_cases.profession.domain.Profession;
import com.esgi.trademe.use_cases.profile.exposition.CertificateResponse;
import com.esgi.trademe.use_cases.profile.exposition.SkillResponse;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Command object
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public final class FillProfile implements Command {
    private String id;
    private User user;
    private Profession profession;
    private Double tjm;
    private String geographicalArea;
    private List<SkillResponse> skills;
    private List<CertificateResponse> certificates;


}
