package com.dailycodework.dream_shops.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CartItem {
    private Long id;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;
    private int quantity;
    private double price;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

    @JsonIgnore 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;
     
    public void setTotalPrice(){
        this.totalPrice= this.unitPrice.multiply(new BigDecimal(quantity));
    }
}
