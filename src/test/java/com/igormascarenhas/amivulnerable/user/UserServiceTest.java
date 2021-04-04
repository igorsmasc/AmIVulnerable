package com.igormascarenhas.amivulnerable.user;

import com.igormascarenhas.amivulnerable.registration.token.ConfirmationTokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ConfirmationTokenService confirmationTokenService;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository, bCryptPasswordEncoder, confirmationTokenService);
    }

    @Test
    void canGetAllUsers() {
        // When
        underTest.getAllUsers();

        // Then
        verify(userRepository).findAll();
    }

    @Test
    void canAddNewUser() {
        // Given

        User user = new User(
                "Igor",
                "Mascarenhas",
                "igor@mail.com",
                "123",
                UserRole.USER
        );

        // When
        underTest.addNewUser(user);

        // Then
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        verify(userRepository).save(userArgumentCaptor.capture());

        User userCaptured = userArgumentCaptor.getValue();

        assertThat(userCaptured).isEqualTo(user);

    }

    @Test
    void willThrowWhenEmailIsTaken() {
        // Given
        User user = new User(
                "Igor",
                "Mascarenhas",
                "igor@mail.com",
                "123",
                UserRole.USER
        );

        Optional<User> userOptional = Optional.of(user);

        given(userRepository.findUserByEmail(anyString()))
                .willReturn(userOptional);

        // When
        // Then
        assertThatThrownBy(() ->
                underTest.addNewUser(user))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("This emails is already in use.");

        verify(userRepository, never()).save(any());
    }

    @Test
    void canDeleteUser() {
        // Given
        Long id = 7L;
        given(userRepository.existsById(id))
                .willReturn(true);

        // When
        underTest.deleteUser(id);

        // Then
        verify(userRepository).deleteById(id);
    }

    @Test
    void willThrowWhenDeleteUserNotFound() {
        // Given
        Long id = 7L;
        given(userRepository.existsById(id))
                .willReturn(false);

        // When
        // Then
        assertThatThrownBy(() -> underTest.deleteUser(id))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("User with id " + id + " does not exists.");

        verify(userRepository, never()).deleteById(any());
    }
}