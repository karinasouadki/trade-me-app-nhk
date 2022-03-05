package com.esgi.trademe.use_cases.profile.infrastructure;

import com.esgi.trademe.use_cases.profile.application.FillProfile;
import com.esgi.trademe.use_cases.profile.exposition.ProfileRequest;
import com.esgi.trademe.use_cases.user.domain.User;

public class ProfileMapper {
    public static FillProfile mapToFillProfile(User user, ProfileRequest profileRequest){
        FillProfile fillProfile = new FillProfile();
        fillProfile.setId(user.getProfile().getId());
        fillProfile.setUser(user);
        fillProfile.setProfession(profileRequest.profession);
        fillProfile.setCertificates(profileRequest.certificates);
        fillProfile.setSkills(profileRequest.skills);
        fillProfile.setTjm(profileRequest.tjm);
        fillProfile.setGeographicalArea(profileRequest.geographicalArea);
        return fillProfile;
    }
}

