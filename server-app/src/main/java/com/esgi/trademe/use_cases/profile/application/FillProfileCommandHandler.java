package com.esgi.trademe.use_cases.profile.application;

import com.esgi.trademe.kernel.CommandHandler;
import com.esgi.trademe.use_cases.profile.domain.Profile;
import com.esgi.trademe.use_cases.profile.domain.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public final class FillProfileCommandHandler implements CommandHandler<FillProfile, Profile> {
    private final ProfileRepository profileRepository;


    @Autowired
    public FillProfileCommandHandler(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile handle(FillProfile fillProfile) {
        ModelMapper modelMapper= new ModelMapper();
        LOGGER.info("Charger le profile de l'utilisateur en base de données : {}", fillProfile.getId());
        Profile profile = modelMapper.map(fillProfile,Profile.class);
        return profileRepository.save(profile);
    }
}
