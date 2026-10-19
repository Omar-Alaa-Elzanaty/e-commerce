package com.dailycodework.dream_shops.dto;

import java.util.List;

import com.dailycodework.dream_shops.model.Order;

import lombok.Data;

@Data 
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Order> orders;
    private CartDto cart;
}
