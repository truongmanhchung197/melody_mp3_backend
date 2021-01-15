package com.c0720i2.melody.model;

import lombok.Data;


@Data
public class Customer {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String address;
    private String email;
    private String tel;
    private String avatar;
}
