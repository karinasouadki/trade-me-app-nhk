package com.esgi.trademe.use_cases.agence.application;

import com.esgi.trademe.kernel.CommandHandler;
import com.esgi.trademe.kernel.configurations.CodeException;
import com.esgi.trademe.kernel.exceptions.BadRequestException;
import com.esgi.trademe.use_cases.agence.domain.Agence;
import com.esgi.trademe.use_cases.agence.domain.AgenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public final class CreateAgenceCommandHandler implements CommandHandler<CreateAgence, Agence> {
    private final AgenceRepository agenceRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CreateAgenceCommandHandler(AgenceRepository agenceRepository, ModelMapper modelMapper) {
        this.agenceRepository = agenceRepository;
        this.modelMapper = modelMapper;
    }

    public Agence handle(CreateAgence createAgence) {
        LOGGER.info("Enregistrement du nouvel utilisateur en base de données : {}", createAgence.getLibelle());
        if(agenceRepository.findAllByLibelle(createAgence.getLibelle()).isPresent()){
            throw new BadRequestException(CodeException.ENTITY_ALREADY_EXISTING);
        }
        Agence agence = modelMapper.map(createAgence, Agence.class);
        return agenceRepository.save(agence);
    }
}
