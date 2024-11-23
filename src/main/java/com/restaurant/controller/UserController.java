

package com.restaurant.controller;

import com.restaurant.services.UserService;
import com.restaurant.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    private ResponseEntity<Users> addUser(@RequestBody Users users) {
        Users addedUser = userService.addUser(users);
        return ResponseEntity.ok(addedUser);
    }

    @GetMapping("/showAll")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(users -> ResponseEntity.ok((Object) users))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Kullanıcı bulunamadı"));
    }
}

