package com.dailycodework.dream_shops.service.cart;

import java.math.BigDecimal;

import com.dailycodework.dream_shops.model.Cart;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(long id);
    BigDecimal getTotalPrice(Long id);
    Long initializeNewCart();
    Cart getCartByUserId(Long userId);
    
}
