package com.esgi.trademe.use_cases.user.exposition;

import com.esgi.trademe.use_cases.user.application.*;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    private final RetrieveUsersHandler retrieveUsersHandler;
    private final CreateUserCommandHandler createUserCommandHandler;
    private final DeleteWorkerCommandHandler deleteWorkerCommandHandler;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(RetrieveUsersHandler retrieveUsersHandler, CreateUserCommandHandler createUserCommandHandler, DeleteWorkerCommandHandler deleteWorkerCommandHandler, ModelMapper modelMapper) {
        this.retrieveUsersHandler = retrieveUsersHandler;
        this.createUserCommandHandler = createUserCommandHandler;
        this.deleteWorkerCommandHandler = deleteWorkerCommandHandler;
        this.modelMapper = modelMapper;
    }


    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersResponse> getAll() {
        LOGGER.info("Tentative de récupération des utilisateurs");
        List<User> users = retrieveUsersHandler.handle(new RetrieveUsers());
        List<UserResponse> userResponseList= users.stream()
                .map(utilisateur -> modelMapper.map(utilisateur,UserResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new UsersResponse(userResponseList));
    }

    @PostMapping(path = "/worker",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createWorker(@RequestBody @Valid UserRequest request) {
        CreateUser createUser = new CreateUser(request.lastname, request.firstname, request.email, request.password, Roles.WORKER);
        User user = createUserCommandHandler.handle(createUser);
        URI location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + user.getId());
        return ResponseEntity.created(location).build();
    }

    @PostMapping(path = "/provider",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProvider(@RequestBody @Valid UserRequest request) {
        CreateUser createUser = new CreateUser(request.lastname, request.firstname, request.email, request.password, Roles.PROVIDER);
        User user = createUserCommandHandler.handle(createUser);
        URI location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + user.getId());
        return ResponseEntity.created(location).build();
    }


    @PostMapping(path = "/admin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createAdmin(@RequestBody @Valid UserRequest request) {
        CreateUser createUser = new CreateUser(request.lastname, request.firstname, request.email, request.password, Roles.ADMIN);
        User user = createUserCommandHandler.handle(createUser);
        URI location = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().build().toUri() + "/" + user.getId());
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@RequestBody String userId) {
       DeleteWorker deleteWorker = new DeleteWorker(userId);
       deleteWorkerCommandHandler.handle(deleteWorker);
       return ResponseEntity.noContent().build();
    }

}