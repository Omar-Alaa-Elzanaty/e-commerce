package com.dailycodework.dream_shops.dto;

import java.math.BigDecimal;
import java.util.Set;

import lombok.Data;

@Data 
public class CartDto {
    private  Long cartId;
    private Set<CartItmeDto> items;
    private  BigDecimal totalAmount;
}
