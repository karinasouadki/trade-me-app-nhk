package com.esgi.trademe.use_cases.user.application;

import com.esgi.trademe.kernel.QueryHandler;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class RetrieveWorkersByIdHandler implements QueryHandler<RetrieveWorkersById, User> {

    private final UserRepository userRepository;

    @Autowired
    public RetrieveWorkersByIdHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(RetrieveWorkersById query) {
        LOGGER.info("Tentative de récupération de les membres par son identifiant en base de données : {}", query.getUserId());
        Optional<User> user = userRepository.findById(query.getUserId());
        if(user.isEmpty()){
            throw new RuntimeException();
        }
        return user.get();

    }
}
