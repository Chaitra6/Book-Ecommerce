package com.springrest.bookecom.service_Impl;

import com.springrest.bookecom.exception.ResourceNotFoundException;
import com.springrest.bookecom.model.Book;
import com.springrest.bookecom.model.Order;
import com.springrest.bookecom.model.OrderItem;
import com.springrest.bookecom.model.User;
import com.springrest.bookecom.repository.BookRepository;
import com.springrest.bookecom.repository.OrderRepository;
import com.springrest.bookecom.repository.UserRepository;
import com.springrest.bookecom.service.BookService;
import com.springrest.bookecom.service.OrderItemsService;
import com.springrest.bookecom.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private OrderItemsService orderItemsService;

    private UserRepository userRepository;

    private BookRepository bookRepository;

    private BookService bookService;



    public OrderServiceImpl(OrderRepository orderRepository, OrderItemsService orderItemsService,
                            UserRepository userRepository, BookRepository bookRepository, BookService bookService) {
        this.orderRepository = orderRepository;
        this.orderItemsService = orderItemsService;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }


    @Override
    public Order saveOrder(long userId, Order order) {


        User user1 = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
        if(user1==null){
            return null;
        }else {
            Long price = 0l;
            order.setUser(user1);
            Order new_Order = orderRepository.save(order);
            long order_id = new_Order.getId();

            for(int i= 0 ; i<order.getBookIds().size(); i++){
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(order_id);
                orderItem.setBookId(order.getBookIds().get(i));
                orderItemsService.addOrderedItem(orderItem);

//                new_Order.getOrderItems().add(orderItem);

                Book book1 = bookService.getBook(order.getBookIds().get(i)) ;
                long stock = book1.getStock();
                long soldUnits = book1.getAvailable_units();
                if(stock-1 == -1){
                    book1.setStock(0);
                    return null;
                }else {
                    book1.setStock(stock-1);
                }

                book1.setAvailable_units(soldUnits+1);


                long book_amt = book1.getPrice();
                price += book_amt;
            }//for

            new_Order.setTotalPrice(price);
            orderRepository.save(new_Order);

//            user1.getOrders().add(new_Order);
//            userRepository.save(user1);



            return order;


        }

    }


    @Override
    public List<Order> getAllOrdersByUserId(long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));

        if(user == null){
            return null;
        }else{
            return orderRepository.findAllOrdersByUserId(userId);
        }

    }

    @Override
    public List<Book> getOrderItemsByUserandOrderId(long userId, long orderId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "ID", orderId));


        if(user==null || order==null){
            return null;
        } else if (order.getUser().getId() != userId) {
            return null;
        }else{
            List<Book> book_list = new ArrayList<>();

            for(int i= 0 ; i<order.getBookIds().size(); i++){
                Book book1 = bookService.getBook(order.getBookIds().get(i)) ;
                book_list.add(book1);
            }

            return book_list;
        }

    }


    @Override
    public boolean deleteUserOrder(long userId, long orderId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order", "ID", orderId));

        if(user==null || order==null){
            return false;
        } else if (order.getUser().getId() != userId) {
            return false;
        } else{
            orderRepository.deleteById(orderId);
            return true;
        }
    }


}



















//            orderItemsService.deleteOrderItemByOrderId(orderId);
