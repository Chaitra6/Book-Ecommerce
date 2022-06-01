package com.springrest.bookecom.controller;

import com.springrest.bookecom.exception.InvalidRequestException;
import com.springrest.bookecom.model.Book;
import com.springrest.bookecom.model.User;
import com.springrest.bookecom.service.BookService;
import com.springrest.bookecom.service.UserService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/admin")
public class UserController {

    private UserService userService;

    private BookService bookService;

    public UserController(UserService userService, BookService bookService) {
        super();
        this.bookService = bookService;
        this.userService = userService;
    }

    // http://localhost:8086/api/admin/users
    // save user
    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws ChangeSetPersister.NotFoundException {
        if(user == null || user.getId() == null){
            throw new InvalidRequestException("User must not be null...!");
        }

        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    // Get all user
 // http://localhost:8086/api/admin/users
    @GetMapping("/users")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }


    // List all the Books
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return  bookService.listAllBooks();
    }

    // Get User By ID
//  http://localhost:8086/api/admin/users/1
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){

        return  new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
    }



    // Update User
    //  http://localhost:8086/api/admin/users/1
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") long id){
        return  new ResponseEntity<User>(userService.updateUser(user, id), HttpStatus.OK);
    }


    //Delete User
    //  http://localhost:8086/api/admin/users/1
    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){

        // Delete Emp from DB
        userService.deleteUser(id);

        return new ResponseEntity<String>("User Deleted Successfully..!!!", HttpStatus.OK );

    }












}
