package com.igormascarenhas.amivulnerable.device;

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
    void canAddNewDevice() {
        // Given
        Device device = new Device(
                "ios",
                "14",
                "iPhone 12 Pro Max");

        // When
            underTest.addNewDevice(device);

        // Then
        ArgumentCaptor<Device> deviceArgumentCaptor =
                ArgumentCaptor.forClass(Device.class);

        verify(deviceRepository).save(deviceArgumentCaptor.capture());

        Device capturedDevice = deviceArgumentCaptor.getValue();

        assertThat(capturedDevice).isEqualTo(device);

    }
}