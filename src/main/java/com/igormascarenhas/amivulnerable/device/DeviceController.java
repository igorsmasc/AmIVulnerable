package com.igormascarenhas.amivulnerable.device;

import com.igormascarenhas.amivulnerable.rule.Rule;
import com.igormascarenhas.amivulnerable.rule.RuleService;
import com.igormascarenhas.amivulnerable.vulnerability.Vulnerability;
import com.igormascarenhas.amivulnerable.vulnerability.VulnerabilityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
@Api(value = "REST API - DEVICE")
@CrossOrigin(origins = "*") //All domains can access it
@AllArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;
    private final VulnerabilityService vulnerabilityService;
    private final RuleService ruleService;
    private KieSession session;

    @GetMapping("/devices")
    @ApiOperation(value = "GET ALL DEVICES")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/device/{deviceId}")
    @ApiOperation(value = "GET DEVICE BY ID")
    public Optional<Device> getDevice(@PathVariable("deviceId") Long id) {
        return deviceService.getDevice(id);
    }

    @PostMapping("/device")
    @ApiOperation(value = "REGISTER A NEW DEVICE")
    public void registerNewDevice(@RequestBody Device device) {
        deviceService.addNewDevice(device);
    }

    @PostMapping("/device/{deviceid}/scan")
    @ApiOperation(value = "SCAN A DEVICE")
    public void doScan(@RequestBody RuleVul ruleVul, @PathVariable("deviceid") Long deviceId) {

        Device device = deviceService.getDevice(deviceId).get();

        session.insert(ruleVul);
        session.fireAllRules();

        ruleVul.getVulnerabilitiesList().forEach(vulId -> device.addVulnerability(vulnerabilityService.getVulnerabilityById(vulId.longValue()).get()));

        ruleVul.getRulesList().forEach(ruleId -> device.addRule(ruleService.getRule(ruleId.longValue()).get()));

        deviceService.addNewDevice(device);

    }

    @DeleteMapping(path = "/device/{deviceId}")
    @ApiOperation(value = "DELETE A DEVICE")
    public void deleteDevice(@PathVariable("deviceId") Long id) {
        deviceService.deleteDevice(id);
    }
}
