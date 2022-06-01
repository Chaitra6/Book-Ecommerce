package com.springrest.bookecom.model;


import com.springrest.bookecom.enums.Role;
import lombok.Data;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;



//@NoArgsConstructor
//@AllArgsConstructor
//@Builder

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNum")
    private String phno;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;



}











//    @JoinColumn(name = "user_id")


//     @JoinColumn(name = "user_id", referencedColumnName = "id")