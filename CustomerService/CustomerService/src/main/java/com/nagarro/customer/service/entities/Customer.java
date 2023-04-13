package com.nagarro.customer.service.entities;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10)
    private String firstName;

    @Column(length = 10)
    private String lastName;

    @Column(length = 40)
    private String email;

    private String phone;

    @Column(length = 40, unique = true)
    private String accountno;

}