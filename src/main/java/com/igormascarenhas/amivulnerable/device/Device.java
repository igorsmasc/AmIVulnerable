package com.igormascarenhas.amivulnerable.device;

import com.igormascarenhas.amivulnerable.vulnerability.Vulnerability;

import java.util.List;

public class Device {
    private String id;
    private String os;
    private String os_version;
    private String model;
    private List<Vulnerability> vulnerabilities;

    public Device() {
    }

    public Device(
            String id,
            String os,
            String os_version,
            String model) {
        this.id = id;
        this.os = os;
        this.os_version = os_version;
        this.model = model;
    }

    public Device(
            String os,
            String os_version,
            String model) {
        this.os = os;
        this.os_version = os_version;
        this.model = model;
    }

    public Device(String id, String os, String os_version, String model, List<Vulnerability> vulnerabilities) {
        this.id = id;
        this.os = os;
        this.os_version = os_version;
        this.model = model;
        this.vulnerabilities = vulnerabilities;
    }

    public Device(String os, String os_version, String model, List<Vulnerability> vulnerabilities) {
        this.os = os;
        this.os_version = os_version;
        this.model = model;
        this.vulnerabilities = vulnerabilities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Vulnerability> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(List<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id='" + id + '\'' +
                ", os='" + os + '\'' +
                ", os_version='" + os_version + '\'' +
                ", model='" + model + '\'' +
                ", vulnerabilities=" + vulnerabilities +
                '}';
    }
}
