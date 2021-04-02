package com.igormascarenhas.amivulnerable.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Api(value = "REST API - USER")
@CrossOrigin(origins = "*") //All domains can access it
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ApiOperation(value = "GET ALL USERS")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user")
    @ApiOperation(value = "REGISTER A NEW USER")
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

}
