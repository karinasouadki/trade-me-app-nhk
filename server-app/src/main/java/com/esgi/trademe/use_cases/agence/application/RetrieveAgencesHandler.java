package com.esgi.trademe.use_cases.agence.application;

import com.esgi.trademe.kernel.QueryHandler;
import com.esgi.trademe.use_cases.agence.domain.Agence;
import com.esgi.trademe.use_cases.agence.domain.AgenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RetrieveAgencesHandler implements QueryHandler<RetrieveAgences, List<Agence>> {

    private final AgenceRepository agenceRepository;

    public RetrieveAgencesHandler(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public List<Agence> handle(RetrieveAgences query) {
        LOGGER.info("Tentative de récupération de la liste des adences en base de données");
        return agenceRepository.findAll();
    }
}
