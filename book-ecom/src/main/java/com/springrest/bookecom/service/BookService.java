package com.springrest.bookecom.service;

import com.springrest.bookecom.model.Book;
import com.springrest.bookecom.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface BookService {



    Book addBook(Long id, Book book);

    List<Book> listAllSellersBooks(long id);


    Book getBook(long book_id);

    Book getSellerBookBySeller_Book_Id(long seller_id, long book_id);

    Book updateBookBySellerIdAndBookId(long seller_id, long book_id, Book book);



    boolean deleteBook(long seller_id, long book_id);

    //For Admin
    List<Book> listAllBooks();

}
