package com.springrest.bookecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springrest.bookecom.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByEmail(String email);
}
