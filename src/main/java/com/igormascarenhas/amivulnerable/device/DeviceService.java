package com.igormascarenhas.amivulnerable.device;

import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    public Device getDevice() {
        return new Device("1", "android", "10", "s10");
    }

}
