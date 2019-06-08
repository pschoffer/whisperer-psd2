package com.techsylvania.klarnauts.whisperer.service;

import com.techsylvania.klarnauts.whisperer.data.domain.User;
import com.techsylvania.klarnauts.whisperer.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(@Autowired UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUser(Long id) {
    return userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
  }

  @Override
  public User getUser(String email) {
    return userRepository.findByEmail(email);
  }
}
