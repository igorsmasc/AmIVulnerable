package com.igormascarenhas.amivulnerable.device;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DeviceServiceTest {

    @Mock
    private DeviceRepository deviceRepository;
    private DeviceService underTest;

    @BeforeEach
    void setUp() {
        underTest = new DeviceService(deviceRepository);
    }

    @Test
    void canGetAllDevices() {
        // When
        underTest.getAllDevices();

        // Then
        verify(deviceRepository).findAll();
    }

    @Test
    @Disabled
    void getDevice() {
    }

    @Test
    @Disabled
    void addNewDevice() {
    }
}