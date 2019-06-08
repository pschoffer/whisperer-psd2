package com.techsylvania.klarnauts.whisperer.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techsylvania.klarnauts.whisperer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public String getUser(@PathVariable Long id) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(userService.getUser(id));
  }

  @GetMapping("/email/{email}")
  public String getUserByEmail(@PathVariable String email) throws JsonProcessingException {
    return new ObjectMapper().writeValueAsString(userService.getUser(email));
  }
}
