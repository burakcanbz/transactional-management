package com.example.order.controller;

import com.example.order.dto.CreateOrderDTO;
import com.example.order.dto.UpdateOrderDTO;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getOrders(){
        return "get all orders";
    }

    @GetMapping("/{id}")
    public String orderById(@PathVariable String id){
        return "get order by id";
    }

    @PostMapping
    public String createOrder(@RequestBody CreateOrderDTO createOrder){
        return "create order";
    }

    @PutMapping("/{id}")
    public String updateOrder(@RequestBody UpdateOrderDTO updateOrder, @PathVariable Long id){
        return "update order";
    }

    @PatchMapping("/{id}")
    public String partialUpdateOrder(@RequestBody UpdateOrderDTO partialUpdateOrder, @PathVariable Long id){
        return "update order";
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id){
        return "delete order";
    }

}