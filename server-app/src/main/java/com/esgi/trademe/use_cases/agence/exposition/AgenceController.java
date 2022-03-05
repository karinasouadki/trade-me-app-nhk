package com.esgi.trademe.use_cases.agence.exposition;

import com.esgi.trademe.use_cases.agence.application.*;
import com.esgi.trademe.use_cases.agence.domain.Agence;
import com.esgi.trademe.use_cases.user.application.DeleteWorker;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/api/agencies")
public class AgenceController {
    private final RetrieveAgencesHandler retrieveAgencesHandler;
    private final RetrieveAgenceHandler retrieveAgenceHandler;
    private final CreateAgenceCommandHandler createAgenceCommandHandler;
    private final DeleteAgenceCommandHandler deleteAgenceCommandHandler;
    private final ModelMapper modelMapper;

    @Autowired
    public AgenceController(RetrieveAgencesHandler retrieveAgencesHandler, RetrieveAgenceHandler retrieveAgenceHandler, CreateAgenceCommandHandler createAgenceCommandHandler, DeleteAgenceCommandHandler deleteAgenceCommandHandler, ModelMapper modelMapper) {
        this.retrieveAgencesHandler = retrieveAgencesHandler;
        this.retrieveAgenceHandler = retrieveAgenceHandler;
        this.createAgenceCommandHandler = createAgenceCommandHandler;
        this.deleteAgenceCommandHandler = deleteAgenceCommandHandler;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/{id}")
    public ResponseEntity getAgence(@PathVariable String id) {
        LOGGER.info("Tentative de récupération d'agence d'identifiant : {}", id);
        Agence agence = retrieveAgenceHandler.handle(new RetrieveAgence(id));
        AgenceResponse agenceResponse = modelMapper.map(agence, AgenceResponse.class);
        return ResponseEntity.ok(agenceResponse);
    }
    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AgencesResponse> getAll() {
        LOGGER.info("Tentative de récupération des agences");
        List<Agence> agences = retrieveAgencesHandler.handle(new RetrieveAgences());
        List<AgenceResponse> agenceResponseList= agences.stream()
                .map(agence -> modelMapper.map(agence, AgenceResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new AgencesResponse(agenceResponseList));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid AgenceRequest request) {
        LOGGER.info("Tentative de création d'une demande {}", request);
        CreateAgence createAgence = modelMapper.map(request, CreateAgence.class);
        Agence agence = createAgenceCommandHandler.handle(createAgence);
        URI location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + agence.getId());
        return ResponseEntity.created(location).build();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody String agenceId) {
        LOGGER.info("Tentative de suppression d'une agence {}", agenceId);
        DeleteAgence deleteAgence = new DeleteAgence(agenceId);
        deleteAgenceCommandHandler.handle(deleteAgence);
        return ResponseEntity.noContent().build();
    }
}