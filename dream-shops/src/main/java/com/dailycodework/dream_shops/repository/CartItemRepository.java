package com.dailycodework.dream_shops.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodework.dream_shops.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    void deleteAllByCartId(long id);

}
