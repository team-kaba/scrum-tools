package com.example.controller;

import com.example.domain.model.EventMember;
import com.example.domain.service.PokerEventService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokerEventController {

  private final PokerEventService pokerEventService;

  public PokerEventController(PokerEventService pokerEventService) {
    this.pokerEventService = pokerEventService;
  }

  @PostMapping(path = "porker-event/create")
  ResponseEntity postProductBacklogItem(
      @RequestParam("amount") String amount, @RequestBody EventMember eventMember) {
    pokerEventService.create(eventMember);
    return new ResponseEntity(HttpStatus.CREATED);
  }

  @GetMapping(path = "host-list/search")
  ResponseEntity<List<EventMember>> getPokerEvents() {
    final List<EventMember> eventMembers = pokerEventService.fetchEventMember();
    return new ResponseEntity<>(eventMembers, HttpStatus.ACCEPTED);
  }
}
