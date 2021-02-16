package com.example.controller;

import com.example.domain.model.ProductBacklogItem;
import com.example.domain.service.ProductBacklogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductBacklogItemController {

  private final ProductBacklogItemService productBacklogItemService;

  @Autowired
  public ProductBacklogItemController(ProductBacklogItemService productBacklogItemService) {
    this.productBacklogItemService = productBacklogItemService;
  }

  @PostMapping(path = "product-backlog-item/create")
  ResponseEntity<Void> postProductBacklogItem(@RequestParam("amount") String amount) {
    productBacklogItemService.create(Integer.parseInt(amount));
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @GetMapping(path = "product-backlog-items")
  ResponseEntity<List<ProductBacklogItem>> getProductBacklogItem(
      @RequestParam("amount") String amount) {
    final List<ProductBacklogItem> productBacklogItems = productBacklogItemService.select(amount);
    return new ResponseEntity(productBacklogItems, HttpStatus.OK);
  }
}
