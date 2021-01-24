package com.example.controller;

import com.example.domain.resource.Greeting;
import com.example.domain.resource.HelloMessage;
import com.example.domain.resource.ProductBacklogItemResource;
import com.example.domain.service.ProductBacklogItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class ProductBacklogItemController {

    private final ProductBacklogItemService productBacklogItemService;

    public ProductBacklogItemController(
            ProductBacklogItemService productBacklogItemService
    ) {
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

    /*@GetMapping()
    ResponseEntity<List<ProductBacklogItem>> getProductBacklogItem(
            // TODO : バリデーションの実装
            @RequestParam("amount") String amount
    ) {
        final List<ProductBacklogItem> productBacklogItems
                = productBacklogItemService.select(amount);
        return new ResponseEntity(productBacklogItems, HttpStatus.OK);
    }*/

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
