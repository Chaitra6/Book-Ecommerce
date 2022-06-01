package com.springrest.bookecom.repository;

import com.springrest.bookecom.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
//    @Query("SELECT b FROM BOOKS b WHERE b.seller_id= ?1" )

    @Query("select b from Book b where b.seller_id = ?1")
    List<Book> findAllBooksByseller_id(long seller_id);

    @Query("select b from Book b where b.seller_id = ?1 and b.id = ?2" )
    Book getSellerBookByseller_idAndBookId(long seller_id, long book_id);


//    @Modifying
//    @Query("DELETE b FROM BOOKS b WHERE b.seller_id = ?1 AND b.id = ?2")
//    Book deleteSellerBookBySeller_idAndBookId(long seller_id, long book_id);
}



























//    @Modifying
//    @Query("UPDATE BOOK b WHERE b.seller_id = ?1 AND b.id = ?2")
//    Book updateBookBySellerIdAndBookId(long seller_id, long book_id);











