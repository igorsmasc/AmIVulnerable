package com.igormascarenhas.amivulnerable.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Api(value = "REST API - USER")
@CrossOrigin(origins = "*") //All domains can access it
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    @ApiOperation(value = "GET ALL USERS")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    @ApiOperation(value = "REGISTER A NEW USER")
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @DeleteMapping(path = "/user/{userId}")
    @ApiOperation(value = "DELETE A USER")
    public void deleteUser(@PathVariable("userId") Long id) {
        userService.deleteUser(id);
    }

}
