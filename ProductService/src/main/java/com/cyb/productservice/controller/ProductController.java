package com.cyb.productservice.controller;

import com.cyb.productservice.entity.Product;
import com.cyb.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private final ProductRepository _productRepository;

  @GetMapping("/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable Long id) {
    Optional<Product> product = _productRepository.findById(id);
    return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    return _productRepository.save(product);
  }

}
