package com.igormascarenhas.amivulnerable.device;

import com.igormascarenhas.amivulnerable.vulnerability.Vulnerability;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    public Device getDevice() {
        return new Device(1, "android", "10", "s10");
    }

}
