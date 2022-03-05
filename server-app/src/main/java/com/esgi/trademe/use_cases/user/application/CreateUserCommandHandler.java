package com.esgi.trademe.use_cases.user.application;

import com.esgi.trademe.kernel.CommandHandler;
import com.esgi.trademe.use_cases.profile.domain.Profile;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public final class CreateUserCommandHandler implements CommandHandler<CreateUser, User> {
    private final UserRepository userRepository;

    @Autowired
    public CreateUserCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handle(CreateUser createUser) {
        LOGGER.info("Enregistrement du nouvel utilisateur en base de données : {}", createUser.getEmail());
        if(userRepository.findByEmail(createUser.getEmail()) == null){
            throw new RuntimeException();
        }
        ModelMapper modelMapper= new ModelMapper();
        createUser.setPassword(createUser.getPassword());
        User user = modelMapper.map(createUser, User.class);
        user.setProfile(new Profile());
        return userRepository.save(user);


    }
}
