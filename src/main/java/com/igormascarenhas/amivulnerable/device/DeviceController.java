package com.igormascarenhas.amivulnerable.device;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@Api(value = "REST API - DEVICE")
@CrossOrigin(origins = "*") //All domains can access it
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/device")
    @ApiOperation(value = "GET DEVICE BY ID")
    public Device getDevice() {
        return deviceService.getDevice();
    }

}
