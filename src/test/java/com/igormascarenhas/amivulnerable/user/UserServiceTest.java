package com.igormascarenhas.amivulnerable.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository);
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
                "igor@mail.com",
                "123",
                "Igor Santos Mascarenhas"
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
                "igor@mail.com",
                "123",
                "Igor Santos Mascarenhas"
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
        Integer id = 7;
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
        Integer id = 7;
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