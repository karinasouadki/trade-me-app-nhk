package com.esgi.trademe.use_cases.subscription.application;

import com.esgi.trademe.kernel.CommandHandler;
import com.esgi.trademe.use_cases.profile.domain.Profile;
import com.esgi.trademe.use_cases.user.application.CreateUser;
import com.esgi.trademe.use_cases.user.domain.User;
import com.esgi.trademe.use_cases.user.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public final class PaymentCommandHandler implements CommandHandler<Payment, Void> {

    public Void handle(Payment payment) {

        return null;
    }
}
