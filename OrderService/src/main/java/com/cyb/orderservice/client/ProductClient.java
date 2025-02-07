package com.cyb.orderservice.client;

import com.cyb.orderservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {
  @GetMapping("/products/{id}")
  Product getProductById(@PathVariable Long id);
}
