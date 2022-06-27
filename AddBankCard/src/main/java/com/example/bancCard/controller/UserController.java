package com.example.bancCard.controller;

import com.example.bancCard.entity.Client;
import com.example.bancCard.exception.UserAlreadyExistException;
import com.example.bancCard.exception.UserNotFoundException;
import com.example.bancCard.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@Validated
@RestController
@RequestMapping("/api/v1")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/user")
  public ResponseEntity<String> registration(@Valid @RequestBody Client client) {
    try {
      userService.registration(client);
      return ResponseEntity.ok("User added successfully");
    }catch (UserAlreadyExistException e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/users/{id}")
  public ResponseEntity getOneUser(@PathVariable Integer id) {
    try {
      return ResponseEntity.ok(userService.getOne(id));
    }catch (UserNotFoundException e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity deleteUser(@PathVariable Integer id) {
    try {
      userService.delete(id);
      return ResponseEntity.ok("User was deleted");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
    }
  }

  @PutMapping("/users/{id}")
  public ResponseEntity<String> update(@PathVariable("id") Integer id, @RequestBody Client client){
    try {
      userService.updateUser(client);
      return ResponseEntity.ok("User update successfully");
    }catch (UserNotFoundException | UserAlreadyExistException e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
