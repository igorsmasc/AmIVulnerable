package com.igormascarenhas.amivulnerable.device;

import java.util.ArrayList;

public class Vulnerabilities {

    private Long deviceId;

    private ArrayList<Integer> vulnerabilitiesList = new ArrayList<Integer>();

    public ArrayList<Integer> getVulnerabilitiesList() {
        return vulnerabilitiesList;
    }

    public boolean findVulnerability(Integer i) {
        return vulnerabilitiesList.contains(i);
    }

    public void setVulnerabilitiesList(ArrayList<Integer> vulnerabilitiesList) {
        this.vulnerabilitiesList = vulnerabilitiesList;
    }

    public void addtVulnerability(int vulnerability) {
        this.vulnerabilitiesList.add(vulnerability);
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }
}
