package com.esgi.trademe.features;

import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.domain.UserRepository;
import com.esgi.trademe.use_cases.user.infrastructure.Roles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

public class CreateWorkerMember {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;

    @Given("{string} is a provider")
    public void isAProvider(String email) {
        User user = userRepository.findByEmail(email);
        Assertions.assertThat(Objects.equals(user.getRole(), Roles.PROVIDER));
    }

    @When("He wants to connect with his login and his password")
    public void heWantsToConnectWithHisLoginAndHisPassword() {
    }

    @Then("He is connected to TradeMe")
    public void heIsConnectedToTradeMe() {
    }
}
