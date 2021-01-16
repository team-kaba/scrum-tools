package com.example;

import com.example.domain.model.ProductBacklogItem;
import com.example.domain.resource.ProductBacklogItemResource;
import com.example.domain.service.ProductBacklogItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-backlog-item")
public class ProductBacklogItemController {

    private final ProductBacklogItemService productBacklogItemService;

    public ProductBacklogItemController(
            ProductBacklogItemService productBacklogItemService) {
        this.productBacklogItemService = productBacklogItemService;
    }

    @PostMapping(path = "create")
    ResponseEntity<Void> postProductBacklogItem(
            @Validated
            @RequestBody ProductBacklogItemResource productBacklogItemResource
    ) {
        productBacklogItemService.insert(productBacklogItemResource);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("{amount}")
    ResponseEntity<List<ProductBacklogItem>> getProductBacklogItem(
            @PathVariable String amount
    ) {
        final List<ProductBacklogItem> productBacklogItems
                = productBacklogItemService.select(amount);
        return new ResponseEntity(productBacklogItems, HttpStatus.OK);
    }
}
