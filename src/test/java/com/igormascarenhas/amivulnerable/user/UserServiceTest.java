package com.igormascarenhas.amivulnerable.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

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
    @Disabled
    void deleteUser() {
    }
}