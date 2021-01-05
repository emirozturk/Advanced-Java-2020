package com.emirozturk.Rest;

import com.emirozturk.Entity.User;
import com.emirozturk.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    IUserService userService;

    public UserRestController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity addUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.addUser(user));
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }
    @PutMapping("/users")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        return ResponseEntity.ok().body(userService.updateUser(user));
    }
    @GetMapping("/users")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @GetMapping("/user/{username}")
    public ResponseEntity<?> getUserbyUserName(@PathVariable String username){
        return ResponseEntity.ok().body(userService.getUserbyUserName(username));
    }
}
