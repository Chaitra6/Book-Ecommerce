package com.springrest.bookecom.repository;

import com.springrest.bookecom.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    void deleteByOrderId(long order_Id);
}
