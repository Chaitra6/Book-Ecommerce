package com.springrest.bookecom.model;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table( name = "orderItems")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    private Long orderId;

    private long bookId;


}













//    @ManyToOne(targetEntity=Order.class, cascade=CascadeType.ALL,fetch=FetchType.EAGER)
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Long order_id;

//    public OrderItem(Long order_id, long bookId) {
//        this.order_id = order_id;
//        this.bookId = bookId;
//    }




//    @ManyToOne(targetEntity=Order.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY)
//    @JoinColumn(name = "order_id")










//    @OneToOne
//    @JoinColumn(name = "book_id", referencedColumnName = "id")
//    private Book book;









//    @Column(name = "bookId", nullable = false)
//    private  Long bookId;
//
//    @Column(name = "order_id", nullable = false)
//    private Long orderId;

//    @Column(name = "quantity")
//    private  int quantity;

//    @Column(name = "price")
//    private @NotNull double price;
