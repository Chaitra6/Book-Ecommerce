package com.springrest.bookecom.controller;


import com.springrest.bookecom.model.Book;
import com.springrest.bookecom.model.Order;
import com.springrest.bookecom.service.OrderItemsService;
import com.springrest.bookecom.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class OrderController {

    private OrderService orderService;

    private OrderItemsService orderItemsService;

    public OrderController(OrderService orderService, OrderItemsService orderItemsService) {
        this.orderService = orderService;
        this.orderItemsService = orderItemsService;
    }

    // save user order
    // http://localhost:8086/api/user/1
    @PostMapping("{user_id}")
    public ResponseEntity<?> saveBook(@PathVariable("user_id") long user_id, @RequestBody Order order) {
      Order order1 = orderService.saveOrder(user_id, order);

      if(order1 == null){
          return new ResponseEntity<String>("User Not Found...  Or  BOOK SOLD OUT...!!!", HttpStatus.NOT_FOUND);
      }
      else{
            return new ResponseEntity<Order>(order1, HttpStatus.CREATED);
        }
    }



    //Get all Orders By User ID
   // http://localhost:8086/api/user/1
    @GetMapping("{user_id}")
    public ResponseEntity<?> getAllOrdersByUserId(@PathVariable("user_id") long user_id){

        List<Order> orderList = orderService.getAllOrdersByUserId(user_id);
        if(orderList == null){
            return new ResponseEntity<String>("User Not Found...", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Order>>(orderList, HttpStatus.CREATED);
        }

    }

    // Get item list by user and order id
    // http://localhost:8086/api/user/4/2
    @GetMapping("{user_id}/{order_id}")
    public ResponseEntity<?> getOrderByUserId(@PathVariable("user_id") long user_id, @PathVariable("order_id") long order_id){

        List<Book> bookList = orderService.getOrderItemsByUserandOrderId(user_id, order_id);
        if(bookList == null){
            return new ResponseEntity<String>("Order Not Found...", HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<List<Book>>(bookList, HttpStatus.CREATED);
        }

    }



    // Delete user order
    // http://localhost:8086/api/user/4/2
    @DeleteMapping("{user_id}/{order_id}")
    public ResponseEntity<String> deleteOrderByUserIdAndOrderId(@PathVariable("user_id") long user_id,@PathVariable("order_id") long order_id){
        boolean order_del = orderService.deleteUserOrder(user_id, order_id);

        if(order_del){
            return new ResponseEntity<String>("Order Deleted Successfully..!!!", HttpStatus.OK );
        }else{
            return new ResponseEntity<String>("Order Deletion Unsuccessful...", HttpStatus.OK );
        }

    }








}
