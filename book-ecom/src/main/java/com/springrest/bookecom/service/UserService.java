package com.springrest.bookecom.service;

import com.springrest.bookecom.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    User updateUser(User user, long id);

    void deleteUser(long id);
}
