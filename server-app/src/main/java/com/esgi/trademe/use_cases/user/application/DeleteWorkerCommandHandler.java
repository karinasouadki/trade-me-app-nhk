package com.esgi.trademe.use_cases.user.application;

import com.esgi.trademe.kernel.CommandHandler;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.domain.UserRepository;
import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public final class DeleteWorkerCommandHandler implements CommandHandler<DeleteWorker, Void> {
    private final UserRepository userRepository;

    @Autowired
    public DeleteWorkerCommandHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Void handle(DeleteWorker deleteWorker) {
        LOGGER.info("Suppression d'ouvrière en base de données : {}", deleteWorker.getUserId());
        Optional<User> worker = userRepository.findById(deleteWorker.getUserId());
        if(worker.isEmpty()){
            throw new RuntimeException();
        }
        if(!Objects.equals(Roles.WORKER,worker.get().getRole())){
            throw new RuntimeException();
        }
        userRepository.deleteById(deleteWorker.getUserId());
        return null;
    }
}
