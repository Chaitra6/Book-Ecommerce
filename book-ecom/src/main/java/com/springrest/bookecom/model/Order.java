package com.springrest.bookecom.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



@Data
@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private LocalDate date = LocalDate.now();

    @Column(name = "total_price")
    private long totalPrice;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


//    private long userId;

    private ArrayList<Long> bookIds;


}










//    @OneToMany(targetEntity=Book.class, fetch=FetchType.EAGER)





//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order_ID")
////    @JoinColumn(name = "order_id")
//    private List<OrderItem> orderItems ;




//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User user;








//    Solution: I placed all annotations at public getter methods. I suppose,
//    Hibernate can't handle cases, when annotations for private fields and public getters are mixed in one class.
//





//    @ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
//    private long user_id;



//f-key take from PathVar
//    @Column(name = "user_id", nullable = false)
//    private @NotBlank Long userId;












//    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
//    private List<OrderItem> orderItems;
// , insertable = false, updatable = false
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "order_FID", referencedColumnName = "id")
//    List<Book> bookList = new ArrayList<>();