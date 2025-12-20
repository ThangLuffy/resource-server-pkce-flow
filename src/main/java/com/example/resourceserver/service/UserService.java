package com.example.resourceserver.service;

import com.example.resourceserver.model.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public List<Users> findUsers() {
        List<Users> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Users item = new Users(
                    i,
                    "user_no_" + i,
                    "email_user_no_" + i,
                    "Full name user no " + i,
                    "22 Lang Ha Street, Hanoi City",
                    "developer in cyber security department");
            users.add(item);
        }
        return users;
    }
}
