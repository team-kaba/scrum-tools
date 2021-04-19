package com.example.controller;

import com.example.domain.model.ProductBacklogItem;
import com.example.domain.service.ProductBacklogItemService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductBacklogItemController {

  private final ProductBacklogItemService productBacklogItemService;

  public ProductBacklogItemController(ProductBacklogItemService productBacklogItemService) {
    this.productBacklogItemService = productBacklogItemService;
  }

  @GetMapping(path = "product-backlog-items")
  ResponseEntity<List<ProductBacklogItem>> getProductBacklogItem(
      @RequestParam("amount") String amount) {
    List<ProductBacklogItem> productBacklogItems = productBacklogItemService.select(amount);
    return new ResponseEntity<>(productBacklogItems, HttpStatus.OK);
  }
}
