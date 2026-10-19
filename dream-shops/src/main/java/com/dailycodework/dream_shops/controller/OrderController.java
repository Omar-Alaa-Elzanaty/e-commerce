package com.dailycodework.dream_shops.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.dream_shops.dto.OrderDto;
import com.dailycodework.dream_shops.model.Order;
import com.dailycodework.dream_shops.response.ApiResponse;
import com.dailycodework.dream_shops.service.order.IOrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    private final IOrderService orderService;

    @PostMapping ("/order")
    public ResponseEntity<ApiResponse>createOrder(@RequestParam Long userId){
        Order order =orderService.placeOrder(userId);
        return ResponseEntity.ok(new ApiResponse("success", order));
    }

    @GetMapping("/{orderId}/order")
    public ResponseEntity<ApiResponse>getOrderById(@PathVariable  Long orderId){
        OrderDto order= orderService.getOrder(orderId);

        return ResponseEntity.ok(new ApiResponse("item order success", order));
    }

    @GetMapping("/{userId}/order")
    public ResponseEntity<ApiResponse>getUserORders(@PathVariable  Long userId ){
        List<OrderDto> order= orderService.getUserOrders(userId);

        return ResponseEntity.ok(new ApiResponse("item order success", order));
    }
}
