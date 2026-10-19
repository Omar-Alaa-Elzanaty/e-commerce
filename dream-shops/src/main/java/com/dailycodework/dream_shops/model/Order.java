package com.dailycodework.dream_shops.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.dailycodework.dream_shops.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
@Entity 
public class Order {
    private  Long orderId;
    private LocalDate orderDate;
    private BigDecimal totalAmount;
    
    @Enumerated(EnumType.STRING)
    private  OrderStatus orderStatus;
    
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems= new HashSet<>();

    @ManyToOne 
    @JoinColumn (name = "user_id")
    private User user;
}