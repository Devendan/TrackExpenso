package com.dev.ExpenseTracker.Controller;

import com.dev.ExpenseTracker.Enitity.Model.UserRequest;
import com.dev.ExpenseTracker.Enitity.Model.UserResponse;
import com.dev.ExpenseTracker.Repository.UserRepository;
import com.dev.ExpenseTracker.Service.IUserService;
import com.dev.ExpenseTracker.Service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("expo/user")
public class UserController {

    private final UserServiceImpl userService ;


    @PostMapping ("/register")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping ("getUser/{id}")
    public ResponseEntity<UserResponse> getUserById( @PathVariable String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/login")
    public ResponseEntity<?> getUserById(@RequestBody UserRequest req){
        return ResponseEntity.ok(userService.loginUser(req));
    }
}
