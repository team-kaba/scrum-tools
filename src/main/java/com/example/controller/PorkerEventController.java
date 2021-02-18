package com.example.controller;

import com.example.domain.model.EventMember;
import com.example.domain.service.PorkerEventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PorkerEventController {

  private final PorkerEventService porkerEventService;

  public PorkerEventController(PorkerEventService porkerEventService) {
    this.porkerEventService = porkerEventService;
  }

  @PostMapping(path = "porker-event/create")
  ResponseEntity<Void> postProductBacklogItem(@RequestParam("amount") String amount,
      @RequestBody EventMember eventMember) {
    porkerEventService.registerMember(eventMember);
    return new ResponseEntity(HttpStatus.CREATED);
  }
}
