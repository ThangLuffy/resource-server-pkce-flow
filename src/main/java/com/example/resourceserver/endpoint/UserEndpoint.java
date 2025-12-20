package com.example.resourceserver.endpoint;

import com.example.resourceserver.model.Users;
import com.example.resourceserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserEndpoint {
    private static final Logger log = LoggerFactory.getLogger(UserEndpoint.class);
    private final UserService userService;


    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }
//    TODO define class global handler exception aop, should use postgresql instead of mock data of model user
//    TODO integrate with public client app, done unit test this api on postman
    @GetMapping("/users")
    public List<Users> findAllUsers(Authentication authentication) {
        log.info("Name of user '{}' forward from public client application", authentication == null ? "" : authentication.getName());
        return userService.findUsers();
    }
}
