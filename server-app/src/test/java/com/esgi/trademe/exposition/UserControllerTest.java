package com.esgi.trademe.exposition;

import com.esgi.trademe.kernel.configurations.SecurityConfig;
import com.esgi.trademe.use_cases.user.application.*;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.exposition.UserController;
import com.esgi.trademe.use_cases.user.exposition.UserRequest;
import com.esgi.trademe.use_cases.user.exposition.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @MockBean
    private CreateUserCommandHandler createUserCommandHandler;
    @MockBean
    private RetrieveUsersHandler retrieveUsersHandler;
    @MockBean
    private DeleteWorkerCommandHandler deleteWorkerCommandHandler;
    @Mock
    private SecurityContext securityContextMocked;
    @Mock
    private Authentication authenticationMocked;
    @Mock
    private UserPrincipal principal;
    @MockBean
    private ModelMapper modelMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void testSecurityContext() {
        given(authenticationMocked.getPrincipal()).willReturn(principal);
        given(principal.getName()).willReturn("Test");
        given(securityContextMocked.getAuthentication()).willReturn(authenticationMocked);
        SecurityContextHolder.setContext(securityContextMocked);
    }

    @WithMockUser(value = "Jean", password = "test", roles = {"PROVIDER"})
    @Test
    public void createWorker() throws Exception {
        User user = new User();
        user.setId("1");
        user.setEmail("anis@test.com");
        user.setPassword("password123");
        user.setFirstname("Anis");
        user.setLastname("Mzoughi");
        UserRequest userRequest = new UserRequest();
        userRequest.email="anis@test.com";
        userRequest.password="password123";
        userRequest.firstname="Anis";
        userRequest.lastname="Mzoughi";

        given(createUserCommandHandler.handle(any())).willReturn(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String createUserJson = objectMapper.writeValueAsString(userRequest);
        MockHttpServletRequestBuilder builder = post("/api/users/worker")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(createUserJson);

        MvcResult requestResult = mockMvc.perform(builder)
                                        .andExpect(status()
                                        .isCreated())
                                        .andReturn();
        MockHttpServletResponse mockHttpServletResponse = requestResult.getResponse();
        assertEquals(
                mockHttpServletResponse.getStatus(),
                HttpStatus.CREATED.value()
        );
    }


    @Test
    @WithMockUser(value = "Pierre", password = "test", roles = {"WORKER"})
    public void createWorkerNot() throws Exception {
        User user = new User();
        user.setId("1");
        user.setEmail("anis@test.com");
        user.setPassword("password123");
        user.setFirstname("Anis");
        user.setLastname("Mzoughi");
        UserRequest userRequest = new UserRequest();
        userRequest.email="anis@test.com";
        userRequest.password="password123";
        userRequest.firstname="Anis";
        userRequest.lastname="Mzoughi";

        given(createUserCommandHandler.handle(any())).willReturn(user);
        ObjectMapper objectMapper = new ObjectMapper();
        String createUserJson = objectMapper.writeValueAsString(userRequest);
        MockHttpServletRequestBuilder builder = post("/api/users/worker")
                .with(csrf())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(createUserJson);

        MvcResult requestResult = mockMvc.perform(builder)
                .andExpect(status()
                        .isCreated())
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = requestResult.getResponse();
        assertEquals(
                mockHttpServletResponse.getStatus(),
                HttpStatus.CREATED.value()
        );
    }
}