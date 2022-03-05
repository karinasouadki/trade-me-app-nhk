package com.esgi.trademe.use_cases.agence.application;

import com.esgi.trademe.kernel.QueryHandler;
import com.esgi.trademe.kernel.exceptions.NoSuchEntityException;
import com.esgi.trademe.use_cases.agence.domain.Agence;
import com.esgi.trademe.use_cases.agence.domain.AgenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class RetrieveAgenceHandler implements QueryHandler<RetrieveAgence, Agence> {

    private final AgenceRepository agenceRepository;

    public RetrieveAgenceHandler(AgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence handle(RetrieveAgence query) {
        Optional<Agence> agence = agenceRepository.findById(query.getId());
        if(agence.isEmpty()){
            throw new NoSuchEntityException("Non trouvé");
        }
        return agence.get();
    }
}
