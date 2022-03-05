package com.esgi.trademe.use_cases.user.application;

import com.esgi.trademe.kernel.QueryHandler;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RetrieveWorkersByAgenceHandler implements QueryHandler<RetrieveWorkersByAgence, List<User>> {

    private final UserRepository userRepository;

    @Autowired
    public RetrieveWorkersByAgenceHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveWorkersByAgence query) {
        LOGGER.info("Tentative de récupération de les membres par agence en base de données : {}", query.getAgenceId());
        List<User> users = userRepository.findAll().stream().filter(user -> Objects.equals(query.getAgenceId(),user.getAgence().getId())).collect(Collectors.toList());
        if(users.isEmpty()){
            throw new RuntimeException();
        }
        return users;

    }
}
