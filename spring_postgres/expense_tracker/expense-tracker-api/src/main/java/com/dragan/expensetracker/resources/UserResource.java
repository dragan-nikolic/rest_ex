package com.dragan.expensetracker.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String, Object> userInfo) {
        String firstName = (String)userInfo.get("firstName");
        String lastName = (String)userInfo.get("lastName");
        String email = (String)userInfo.get("email");
        String password = (String)userInfo.get("password");

        return firstName + ", " + lastName + ", " + email + ", " + password;
    }
}
