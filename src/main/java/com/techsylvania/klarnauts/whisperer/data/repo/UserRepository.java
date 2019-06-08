package com.techsylvania.klarnauts.whisperer.data.repo;

import com.techsylvania.klarnauts.whisperer.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Override
  Optional<User> findById(Long id);

  @Query(
      nativeQuery = true,
      value =
          "SELECT id, email, password, birth_date, gender, zip_code, city, country"
              + " FROM public.user"
              + " WHERE lower(email) = lower(?1)")
  User findByEmail(String email);
}
