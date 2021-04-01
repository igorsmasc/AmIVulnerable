package com.igormascarenhas.amivulnerable.user;

import com.igormascarenhas.amivulnerable.device.Device;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        return List.of(
                new User("1", "igor@mail.com", "", List.of(new Device(1, "android", "10", "s10"))),
                new User("2", "amanda@mail.com", "", List.of(new Device(2, "iphone", "10", "lite")))
        );
    }

}
