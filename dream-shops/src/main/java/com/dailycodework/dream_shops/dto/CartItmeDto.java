package com.dailycodework.dream_shops.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CartItmeDto {
    private Long itemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private ProductDto product;
}
