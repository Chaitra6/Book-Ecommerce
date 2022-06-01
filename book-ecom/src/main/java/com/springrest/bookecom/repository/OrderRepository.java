package com.springrest.bookecom.repository;

import com.springrest.bookecom.model.Order;
import com.springrest.bookecom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    @Query("select o from Order o where o.user_id = ?1")
    List<Order> findAllOrdersByUserId(long user_Id);



}





//@Query("delete from orders o where o.user_id=:user_id and o.id=:order_Id")

//    @Query("DELETE o FROM ORDERS o WHERE o.user_id = ?1 AND o.id = ?2")

//    @Query("select o from Order o where o.user_id = ?1")