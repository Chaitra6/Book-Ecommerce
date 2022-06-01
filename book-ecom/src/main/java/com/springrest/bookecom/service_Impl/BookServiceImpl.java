package com.springrest.bookecom.service_Impl;

import com.springrest.bookecom.enums.Role;
import com.springrest.bookecom.exception.ResourceNotFoundException;
import com.springrest.bookecom.model.Book;
import com.springrest.bookecom.model.User;
import com.springrest.bookecom.repository.BookRepository;
import com.springrest.bookecom.repository.UserRepository;
import com.springrest.bookecom.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private UserRepository userRepository;

    public BookServiceImpl(BookRepository bookRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Long id, Book book) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
        if(user.getRole()== Role.SELLER){
            book.setSeller_id(user.getId());
            return bookRepository.save(book);
        }
        else{
            return null;
        }
    }


    @Override
    public List<Book> listAllSellersBooks(long seller_id) {
        return bookRepository.findAllBooksByseller_id(seller_id);
    }

    @Override
    public Book getBook(long book_id) {
        return bookRepository.findById(book_id).orElseThrow(() -> new ResourceNotFoundException("Book", "ID", book_id));

    }

    //For admin
    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }



    @Override
    public Book getSellerBookBySeller_Book_Id(long seller_id, long book_id) {

        //Check if Seller and Book Exists
        User user = userRepository.findById(seller_id).orElseThrow(() -> new ResourceNotFoundException("Seller", "ID", seller_id));
        Book book = bookRepository.findById(book_id).orElseThrow(() -> new ResourceNotFoundException("Book", "ID", book_id));

        if(user==null || book==null){
            return null;
        }else{
            return bookRepository.getSellerBookByseller_idAndBookId(seller_id, book_id);
        }
    }




    @Override
    public Book updateBookBySellerIdAndBookId(long seller_id, long book_id, Book book) {
        //Check if Seller and Book Exists
        Book book_exist = getSellerBookBySeller_Book_Id(seller_id, book_id);


        if(book_exist == null){
            return null;
        }else{
            book_exist.setName(book.getName());
            book_exist.setAuthor(book.getAuthor());
            book_exist.setStock(book.getStock());
            book_exist.setPrice(book.getPrice());

            bookRepository.save(book_exist);
            return book_exist;
        }


    }


    @Override
    public boolean deleteBook(long seller_id, long book_id) {
        Book book_exist = getSellerBookBySeller_Book_Id(seller_id, book_id);

        if(book_exist == null){
            return false;
        }
        else {
            bookRepository.deleteById(book_id);
            return true;
        }


    }
}
