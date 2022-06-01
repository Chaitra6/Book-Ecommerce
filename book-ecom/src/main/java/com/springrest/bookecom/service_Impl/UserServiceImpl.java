package com.springrest.bookecom.service_Impl;

import com.springrest.bookecom.exception.InvalidRequestException;
import com.springrest.bookecom.repository.UserRepository;
import com.springrest.bookecom.exception.ResourceNotFoundException;
import com.springrest.bookecom.model.User;
import com.springrest.bookecom.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new InvalidRequestException("User with "+ id + " Not found"));

    }

    @Override
    public User updateUser(User user, long id) {
        // check if the user exists

        User existUser = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "ID", id));

        existUser.setName(user.getName());
        existUser.setEmail(user.getEmail());
        existUser.setPhno(user.getPhno());

        userRepository.save(existUser);

        return existUser;
    }

    @Override
    public void deleteUser(long id) {

        userRepository.findById(id).orElseThrow(() -> new InvalidRequestException("User with "+ id + " Not found"));
        userRepository.deleteById(id);

    }
}














//        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));


//        User existUser = userRepository.findById(id).orElseThrow(() -> new InvalidRequestException("User with "+ id + " Not found"));


//        userRepository.findById(id).orElseThrow(() ->
//                new ResourceNotFoundException("User", "ID", id));