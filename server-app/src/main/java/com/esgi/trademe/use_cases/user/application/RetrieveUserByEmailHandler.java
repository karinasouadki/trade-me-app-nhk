package com.esgi.trademe.use_cases.user.application;

import com.esgi.trademe.kernel.QueryHandler;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RetrieveUserByEmailHandler implements QueryHandler<RetrieveUserByEmail, User> {

    private final UserRepository userRepository;

    @Autowired
    public RetrieveUserByEmailHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handle(RetrieveUserByEmail query) {
        LOGGER.info("Tentative de récupération de l'utilisateur en base de données : {}", query.getEmail());
        User user = userRepository.findByEmail(query.getEmail());
        if(user == null){
            throw new RuntimeException();
        }
        return user;

    }
}
