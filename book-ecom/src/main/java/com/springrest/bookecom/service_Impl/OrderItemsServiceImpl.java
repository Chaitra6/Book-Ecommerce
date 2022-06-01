package com.springrest.bookecom.service_Impl;

import com.springrest.bookecom.model.OrderItem;
import com.springrest.bookecom.repository.OrderItemRepository;
import com.springrest.bookecom.service.OrderItemsService;
import org.springframework.stereotype.Service;


@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    private OrderItemRepository orderItemRepository;

    public OrderItemsServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem addOrderedItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

//    @Override
//    public void deleteOrderItemByOrderId(long orderId) {
//        orderItemRepository.deleteByOrderId(orderId);
//    }
}
