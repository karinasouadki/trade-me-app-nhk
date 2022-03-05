package com.esgi.trademe.use_cases.profile.exposition;

import com.esgi.trademe.use_cases.profile.application.FillProfile;
import com.esgi.trademe.use_cases.profile.application.FillProfileCommandHandler;
import com.esgi.trademe.use_cases.profile.domain.Profile;
import com.esgi.trademe.use_cases.profile.infrastructure.ProfileMapper;
import com.esgi.trademe.use_cases.user.application.RetrieveWorkersById;
import com.esgi.trademe.use_cases.user.application.RetrieveWorkersByIdHandler;
import com.esgi.trademe.use_cases.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/api/users")
public class ProfileController {
    private final RetrieveWorkersByIdHandler retrieveWorkersByIdHandler;
    private final FillProfileCommandHandler fillProfileCommandHandler;
    private final ModelMapper modelMapper;

    @Autowired
    public ProfileController(RetrieveWorkersByIdHandler retrieveWorkersByIdHandler, FillProfileCommandHandler fillProfileCommandHandler, ModelMapper modelMapper) {
        this.retrieveWorkersByIdHandler = retrieveWorkersByIdHandler;
        this.fillProfileCommandHandler = fillProfileCommandHandler;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('WORKER')")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfileResponse> fillProfile(@PathVariable String id,@RequestBody @Valid ProfileRequest request) {
        User user = retrieveWorkersByIdHandler.handle(new RetrieveWorkersById(id));
        FillProfile fillProfile = ProfileMapper.mapToFillProfile(user,request);
        Profile profile = fillProfileCommandHandler.handle(fillProfile);
        ProfileResponse profileResponse = modelMapper.map(profile,ProfileResponse.class);
        return ResponseEntity.ok(profileResponse);
    }
}
