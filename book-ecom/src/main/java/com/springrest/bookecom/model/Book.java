package com.springrest.bookecom.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.springrest.bookecom.model.User;

import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "seller_id", nullable = false)
    private long seller_id ;

    @Column(name = "stock",nullable = false)
    private long stock;

    @Column(name = "sold_units",nullable = false)
    private long available_units = 0;

    @Column(name = "price",nullable = false)
    private long price;





}



























//    @ManyToOne(targetEntity=Order.class, fetch=FetchType.LAZY)
//    private Order order;

