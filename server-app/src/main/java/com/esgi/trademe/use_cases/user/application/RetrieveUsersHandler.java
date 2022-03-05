package com.esgi.trademe.use_cases.user.application;

import com.esgi.trademe.kernel.QueryHandler;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RetrieveUsersHandler implements QueryHandler<RetrieveUsers, List<User>> {

    private final UserRepository userRepository;
    @Autowired
    public RetrieveUsersHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(RetrieveUsers query) {
        LOGGER.info("Tentative de récupération de la liste des utilisateurs en base de données");
        return userRepository.findAll();
    }
}
