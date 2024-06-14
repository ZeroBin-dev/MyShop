package com.cyb.orderservice.controller;

import com.cyb.orderservice.client.ProductClient;
import com.cyb.orderservice.client.UserClient;
import com.cyb.orderservice.entity.Order;
import com.cyb.orderservice.entity.Product;
import com.cyb.orderservice.entity.User;
import com.cyb.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderRepository _orderRepository;

  private final UserClient _userClient;

  private final ProductClient _productClient;

  @GetMapping("/user/{userId}")
  public User getUserById(@PathVariable Long userId) {
    return _userClient.getUserById(userId);
  }

  @PostMapping
  public ResponseEntity<Order> createOrder(@RequestBody Order order) {

    User user = _userClient.getUserById(order.getUser_id());
    if (user == null) {
      return ResponseEntity.badRequest().build();
    }

    Product product = _productClient.getProductById(order.getProduct_id());
    if (product == null) {
      return ResponseEntity.badRequest().build();
    }

    Order savedOrder = _orderRepository.save(order);
    return ResponseEntity.ok(savedOrder);
  }

}
