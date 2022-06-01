package com.springrest.bookecom.service;

import com.springrest.bookecom.model.Book;
import com.springrest.bookecom.model.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface OrderService {

    // userid- Path var, Order - Req Body
    Order saveOrder(long userId, Order order);

    List<Order> getAllOrdersByUserId(long userId);


    List<Book> getOrderItemsByUserandOrderId(long userId, long orderId);

    boolean deleteUserOrder(long userId, long orderId);


}
