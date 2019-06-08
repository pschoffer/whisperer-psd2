package com.techsylvania.klarnauts.whisperer.service;

import com.techsylvania.klarnauts.whisperer.data.domain.User;

public interface UserService {

  User getUser(Long id);

  User getUser(String email);
}
