package com.igormascarenhas.amivulnerable.device;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Api(value = "REST API - DEVICE")
@CrossOrigin(origins = "*") //All domains can access it
@AllArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @GetMapping("/devices")
    @ApiOperation(value = "GET ALL DEVICES")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/device")
    @ApiOperation(value = "GET DEVICE BY ID")
    public Device getDevice() {
        return deviceService.getDevice();
    }

    @PostMapping("/device")
    @ApiOperation(value = "REGISTER A NEW DEVICE")
    public void registerNewDevice(@RequestBody Device device) {
        deviceService.addNewDevice(device);
    }

    @DeleteMapping(path = "/device/{deviceId}")
    @ApiOperation(value = "DELETE A DEVICE")
    public void deleteDevice(@PathVariable("deviceId") Long id) {
        deviceService.deleteDevice(id);
    }
}
