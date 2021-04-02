package com.igormascarenhas.amivulnerable.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    public Device getDevice() {
        return new Device(1, "android", "10", "s10");
    }

    public void addNewDevice(Device device) {
        deviceRepository.save(device);
    }

}
