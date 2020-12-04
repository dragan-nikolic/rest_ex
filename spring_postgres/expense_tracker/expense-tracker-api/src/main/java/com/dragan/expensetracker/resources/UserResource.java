package com.dragan.expensetracker.resources;

import com.dragan.expensetracker.domain.User;
import com.dragan.expensetracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userInfo) {
        String firstName = (String)userInfo.get("firstName");
        String lastName = (String)userInfo.get("lastName");
        String email = (String)userInfo.get("email");
        String password = (String)userInfo.get("password");

        User user = userService.registerUser(firstName, lastName, email, password);
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", new Date().toString());
        map.put("user", user.toString());
        map.put("message", "User registered successfully.");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> userInfo) {
        String email = (String)userInfo.get("email");
        String password = (String)userInfo.get("password");

        userService.validateUser(email, password);
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", new Date().toString());
        map.put("message", "User " + email + " logged in successfully.");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
