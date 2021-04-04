package com.igormascarenhas.amivulnerable.registration;

import com.igormascarenhas.amivulnerable.user.User;
import com.igormascarenhas.amivulnerable.user.UserRole;
import com.igormascarenhas.amivulnerable.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest registrationRequest) {
        boolean isValidEmail = emailValidator
                .test(registrationRequest.getEmail());

        if(!isValidEmail) {
            throw new IllegalStateException("Email not valid");
        }

        return userService.signUpUser(
                new User(
                        registrationRequest.getFirstName(),
                        registrationRequest.getLastName(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPassword(),
                        UserRole.USER
                )
        );
    }
}
