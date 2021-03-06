package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;
    private String tel;
    private String avatar;
    @OneToOne
    private User user;

}
