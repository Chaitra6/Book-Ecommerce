package com.springrest.bookecom.service;

import com.springrest.bookecom.model.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface OrderItemsService {

    OrderItem addOrderedItem(OrderItem orderItem);

//    void deleteOrderItemByOrderId(long orderId);

}
