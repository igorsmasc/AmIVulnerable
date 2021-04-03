package com.igormascarenhas.amivulnerable.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldFindUserByEmail() {
        // Given
        String email = "igor@mail.com";
        User user = new User(
                email,
                "123",
                "Igor Santos Mascarenhas"
        );
        underTest.save(user);

        // When
        boolean expected = underTest.findUserByEmail(email).isPresent();

        // Then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldNotFindUserByEmail() {
        // Given
        String email = "notfound@mail.com";

        // When
        boolean expected = underTest.findUserByEmail(email).isPresent();

        // Then
        assertThat(expected).isFalse();
    }
}