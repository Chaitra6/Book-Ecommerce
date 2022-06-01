package com.springrest.bookecom.controller;

import com.springrest.bookecom.model.Book;
import com.springrest.bookecom.model.User;
import com.springrest.bookecom.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books/seller")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // http://localhost:8086/api/books/seller/1
    // save book with seller id by checking user role
    @PostMapping("{id}")
    public ResponseEntity<?> saveBook(@PathVariable("id") long id, @RequestBody Book book) {
        Book book_add = bookService.addBook(id, book);
        if(book_add == null){
            return new ResponseEntity<String>("User is not a Seller... Book isn't added ", HttpStatus.FORBIDDEN);
        }
        else{
            return new ResponseEntity<Book>(bookService.addBook(id, book), HttpStatus.CREATED);
        }
    }



    // Get all books of the seller
    // http://localhost:8086/api/books/seller/1
    @GetMapping("{seller_id}")
    public List<Book> getAllSellerBooks(@PathVariable("seller_id") long seller_id){
        return bookService.listAllSellersBooks(seller_id);
    }


    // Get Seller Book by BookID
    // http://localhost:8086/api/books/seller/1/1
    @GetMapping("{seller_id}/{book_id}")
    public ResponseEntity<?> getSellerBookBySeller_Book_Id(@PathVariable("seller_id") long seller_id, @PathVariable("book_id") long book_id){
        Book book = bookService.getSellerBookBySeller_Book_Id(seller_id, book_id);
        if(book == null){
            return new ResponseEntity<String>("User or Book Not Found...!!! ", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }


    }



    // Update Book
    // http://localhost:8086/api/books/seller/1/1
    @PutMapping("{seller_id}/{book_id}")
    public ResponseEntity<?> updateBookBySellerIdAndBookId(@PathVariable("seller_id") long seller_id, @PathVariable("book_id") long book_id, @RequestBody Book book ){
        Book book_exist = bookService.updateBookBySellerIdAndBookId(seller_id, book_id, book);
        if(book_exist == null){
            return new ResponseEntity<String>("User or Book Not Found...!!! ", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Book>(book_exist, HttpStatus.OK);
        }
    }


    // Delete Book
    // http://localhost:8086/api/books/seller/1/1
    @DeleteMapping("{seller_id}/{book_id}")
    public ResponseEntity<String> deleteUser(@PathVariable("seller_id") long seller_id, @PathVariable("book_id") long book_id){


        boolean del_book = bookService.deleteBook(seller_id, book_id);
        if(del_book){
            return new ResponseEntity<String>("Book Deleted Successfully..!!!", HttpStatus.OK );
        }else{
            return new ResponseEntity<String>("Book Deletion Unsuccessful...", HttpStatus.NOT_FOUND );
        }


    }


}
