package com.igormascarenhas.amivulnerable.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void itShouldFindUserByEmail() {
        // Given String email, String password, String name
        String email = "igor@mail.com";
        User user = new User(
                email,
                "123",
                "Igor Santos Mascarenhas"
        );

        userRepository.save(user);

        // When
        boolean expected = userRepository.findUserByEmail(email).isPresent();

        // Then
        assertThat(expected).isTrue();

    }
}