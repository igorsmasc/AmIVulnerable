package com.igormascarenhas.amivulnerable.device;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDevice(Long deviceId) {
        boolean exists = deviceRepository.existsById(deviceId);
        if(!exists) {
            throw new IllegalStateException("Device with id " + deviceId + " does not exists.");
        }

        return deviceRepository.findById(deviceId);
    }

    public void addNewDevice(Device device) {
        deviceRepository.save(device);
    }

    public void deleteDevice(Long deviceId) {
        boolean exists = deviceRepository.existsById(deviceId);
        if(!exists) {
            throw new IllegalStateException("Device with id " + deviceId + " does not exists.");
        }
        deviceRepository.deleteById(deviceId);
    }

}
