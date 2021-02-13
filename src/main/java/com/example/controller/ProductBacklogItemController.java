package com.example.controller;

import com.example.domain.model.ProductBacklogItem;
import com.example.domain.service.ProductBacklogItemService;
import com.example.handler.RefinementActorListenerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductBacklogItemController {

  private final ProductBacklogItemService productBacklogItemService;
  private final RefinementActorListenerManager refinementActorListenerManager;

  @Autowired
  public ProductBacklogItemController(
      ProductBacklogItemService productBacklogItemService,
      RefinementActorListenerManager refinementActorListenerManager) {
    this.productBacklogItemService = productBacklogItemService;
    this.refinementActorListenerManager = refinementActorListenerManager;
  }

  @PostMapping(path = "product-backlog-item/create")
  ResponseEntity<Void> postProductBacklogItem(
      @RequestParam("amount") String amount,
      @Validated @RequestBody ProductBacklogItem productBacklogItem) {
    productBacklogItemService.create(Integer.parseInt(amount));
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @GetMapping(path = "product-backlog-items")
  ResponseEntity<List<ProductBacklogItem>> getProductBacklogItem(
      // TODO : バリデーションの実装
      @RequestParam("amount") String amount) {
    final List<ProductBacklogItem> productBacklogItems = productBacklogItemService.select(amount);
    return new ResponseEntity(productBacklogItems, HttpStatus.OK);
  }
}
