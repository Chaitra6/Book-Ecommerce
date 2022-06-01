//package com.springrest.bookecom.model;
//
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Table( name = "userOrder")
//public class UserOrder {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @ManyToOne
////    @JsonIgnore
//    @JoinColumn(name = "order_id", referencedColumnName = "id")
//    private Order order;
//
//
//    @ManyToOne()
////    @JsonIgnore
//    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
//    private User user;
//}
