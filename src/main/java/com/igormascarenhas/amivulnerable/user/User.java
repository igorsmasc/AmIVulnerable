package com.igormascarenhas.amivulnerable.user;

import com.igormascarenhas.amivulnerable.device.Device;

import java.util.List;

public class User {

    private String id;
    private String email;
    private String password;
    private String name;
    private List<Device> devices;

    public User() {
    }

    public User(String id, String email, String password, String name, List<Device> devices) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.devices = devices;
    }

    public User(String email, String password, String name, List<Device> devices) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.devices = devices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", devices=" + devices +
                '}';
    }
}
