package com.esgi.trademe.use_cases.agence.application;

import com.esgi.trademe.kernel.CommandHandler;
import com.esgi.trademe.kernel.exceptions.BadRequestException;
import com.esgi.trademe.use_cases.agence.domain.Agence;
import com.esgi.trademe.use_cases.agence.domain.AgenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public final class DeleteAgenceCommandHandler implements CommandHandler<DeleteAgence, Void> {
    private final AgenceRepository agenceRepository;

    @Autowired
    public DeleteAgenceCommandHandler(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    public Void handle(DeleteAgence deleteAgence) {
        LOGGER.info("Suppression d'agence en base de données : {}", deleteAgence.getAgenceId());
        Optional<Agence> agence = agenceRepository.findById(deleteAgence.getAgenceId());
        if(agence.isEmpty()){
            throw new BadRequestException(CodeException.ENTITY_NOT_FOUND);
        }
        agenceRepository.deleteById(deleteAgence.getAgenceId());
        return null;
    }
}
