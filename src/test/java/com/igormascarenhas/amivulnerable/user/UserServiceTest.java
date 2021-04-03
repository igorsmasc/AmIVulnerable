package com.igormascarenhas.amivulnerable.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

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
    @Disabled
    void addNewUser() {
    }

    @Test
    @Disabled
    void deleteUser() {
    }
}